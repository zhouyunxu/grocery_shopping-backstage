<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
            <el-form-item label="商品名称" prop="goodName">
                <el-input v-model="queryParams.goodName" placeholder="请输入商品名称" clearable size="small"
                    @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="商品价格" prop="goodPrice">
                <el-input v-model="queryParams.goodPrice" placeholder="请输入商品价格" clearable size="small"
                    @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="商品图片">
                <ImageUpload v-model="queryParams.goodUrl" />
            </el-form-item>
            <el-form-item label="是否上架(0未上架1上架)" prop="isGroup">
                <el-input v-model="queryParams.isGroup" placeholder="请输入是否上架(0未上架    1上架)" clearable size="small"
                    @keyup.enter.native="handleQuery" />
            </el-form-item>
            <el-form-item label="上架时间" prop="upTime">
                <el-date-picker clearable size="small" v-model="queryParams.upTime" type="date" value-format="yyyy-MM-dd"
                    placeholder="选择上架时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="下架时间" prop="downTime">
                <el-date-picker clearable size="small" v-model="queryParams.downTime" type="date" value-format="yyyy-MM-dd"
                    placeholder="选择下架时间">
                </el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                    v-hasPermi="['system:good:add']">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
                    v-hasPermi="['system:good:edit']">修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete"
                    v-hasPermi="['system:good:remove']">删除</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="warning" plain icon="el-icon-download" size="mini" :loading="exportLoading"
                    @click="handleExport" v-hasPermi="['system:good:export']">导出</el-button>
            </el-col>
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>

        <el-table v-loading="loading" :data="goodList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column label="商品id" align="center" prop="goodId" />
            <el-table-column label="商品名称" align="center" prop="goodName" />
            <el-table-column label="商品价格" align="center" prop="goodPrice" />
            <el-table-column label="商品描述" align="center" prop="goodDepict" />
            <el-table-column label="商品图片" align="center" prop="goodUrl">
                <!-- 表格显示图片 -->
                <template slot-scope="scope">
                    <img :src="scope.row.goodUrl" alt="" style="width: 100px;height: 100px">
                </template>
            </el-table-column>
            <el-table-column label="是否上架(0未上架    1上架)" align="center" prop="isGroup" />
            <el-table-column label="上架时间" align="center" prop="upTime" width="180">
                <template slot-scope="scope">
                    <span>{{ parseTime(scope.row.upTime, '{y}-{m}-{d}') }}</span>
                </template>
            </el-table-column>
            <el-table-column label="下架时间" align="center" prop="downTime" width="180">
                <template slot-scope="scope">
                    <span>{{ parseTime(scope.row.downTime, '{y}-{m}-{d}') }}</span>
                </template>
            </el-table-column>
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
                <template slot-scope="scope">
                    <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)"
                        v-hasPermi="['system:good:edit']">修改</el-button>
                    <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)"
                        v-hasPermi="['system:good:remove']">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize"
            @pagination="getList" />

        <!-- 添加或修改杂货店商品管理对话框 -->
        <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-form-item label="商品名称" prop="goodName">
                    <el-input v-model="form.goodName" placeholder="请输入商品名称" />
                </el-form-item>
                <el-form-item label="商品价格" prop="goodPrice">
                    <el-input v-model="form.goodPrice" placeholder="请输入商品价格" />
                </el-form-item>
                <el-form-item label="商品描述" prop="goodDepict">
                    <el-input v-model="form.goodDepict" type="textarea" placeholder="请输入内容" />
                </el-form-item>
                <el-form-item label="商品图片" prop="goodUrl">
                    <el-input v-model="form.goodUrl" type="textarea" placeholder="请输入内容" />
                </el-form-item>
                <el-form-item label="是否上架(0未上架    1上架)" prop="isGroup">
                    <el-input v-model="form.isGroup" placeholder="请输入是否上架(0未上架    1上架)" />
                </el-form-item>
                <el-form-item label="上架时间" prop="upTime">
                    <el-date-picker clearable size="small" v-model="form.upTime" type="date" value-format="yyyy-MM-dd"
                        placeholder="选择上架时间">
                    </el-date-picker>
                </el-form-item>
                <el-form-item label="下架时间" prop="downTime">
                    <el-date-picker clearable size="small" v-model="form.downTime" type="date" value-format="yyyy-MM-dd"
                        placeholder="选择下架时间">
                    </el-date-picker>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
                <el-button @click="cancel">取 消</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import { listGood, getGood, delGood, addGood, updateGood, exportGood } from "@/api/system/good";

export default {
    name: "Good",
    components: {
    },
    data() {
        return {
            // 遮罩层
            loading: true,
            // 导出遮罩层
            exportLoading: false,
            // 选中数组
            ids: [],
            // 非单个禁用
            single: true,
            // 非多个禁用
            multiple: true,
            // 显示搜索条件
            showSearch: true,
            // 总条数
            total: 0,
            // 杂货店商品管理表格数据
            goodList: [],
            // 弹出层标题
            title: "",
            // 是否显示弹出层
            open: false,
            // 查询参数
            queryParams: {
                pageNum: 1,
                pageSize: 10,
                goodName: null,
                goodPrice: null,
                goodDepict: null,
                goodUrl: null,
                isGroup: null,
                upTime: null,
                downTime: null,
            },
            // 表单参数
            form: {},
            // 表单校验
            rules: {
            }
        };
    },
    created() {
        this.getList();
    },
    methods: {
        /** 查询杂货店商品管理列表 */
        getList() {
            this.loading = true;
            listGood(this.queryParams).then(response => {
                console.log(response);
                this.goodList = response.rows;
                this.total = response.total;
                this.loading = false;
            });
        },
        // 取消按钮
        cancel() {
            this.open = false;
            this.reset();
        },
        // 表单重置
        reset() {
            this.form = {
                goodId: null,
                goodName: null,
                goodPrice: null,
                goodDepict: null,
                goodUrl: null,
                isGroup: null,
                upTime: null,
                downTime: null,
                createBy: null,
                createTime: null,
                updateBy: null,
                updateTime: null
            };
            this.resetForm("form");
        },
        /** 搜索按钮操作 */
        handleQuery() {
            this.queryParams.pageNum = 1;
            this.getList();
        },
        /** 重置按钮操作 */
        resetQuery() {
            this.resetForm("queryForm");
            this.handleQuery();
        },
        // 多选框选中数据
        handleSelectionChange(selection) {
            this.ids = selection.map(item => item.goodId)
            this.single = selection.length !== 1
            this.multiple = !selection.length
        },
        /** 新增按钮操作 */
        handleAdd() {
            this.reset();
            this.open = true;
            this.title = "添加杂货店商品管理";
        },
        /** 修改按钮操作 */
        handleUpdate(row) {
            this.reset();
            const goodId = row.goodId || this.ids
            getGood(goodId).then(response => {
                this.form = response.data;
                this.open = true;
                this.title = "修改杂货店商品管理";
            });
        },
        /** 提交按钮 */
        submitForm() {
            this.$refs["form"].validate(valid => {
                if (valid) {
                    if (this.form.goodId != null) {
                        updateGood(this.form).then(response => {
                            this.msgSuccess("修改成功");
                            this.open = false;
                            this.getList();
                        });
                    } else {
                        addGood(this.form).then(response => {
                            this.msgSuccess("新增成功");
                            this.open = false;
                            this.getList();
                        });
                    }
                }
            });
        },
        /** 删除按钮操作 */
        handleDelete(row) {
            const goodIds = row.goodId || this.ids;
            this.$confirm('是否确认删除杂货店商品管理编号为"' + goodIds + '"的数据项?', "警告", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            }).then(function () {
                return delGood(goodIds);
            }).then(() => {
                this.getList();
                this.msgSuccess("删除成功");
            }).catch(() => { });
        },
        /** 导出按钮操作 */
        handleExport() {
            const queryParams = this.queryParams;
            this.$confirm('是否确认导出所有杂货店商品管理数据项?', "警告", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning"
            }).then(() => {
                this.exportLoading = true;
                return exportGood(queryParams);
            }).then(response => {
                this.download(response.msg);
                this.exportLoading = false;
            }).catch(() => { });
        }
    }
};
</script>
