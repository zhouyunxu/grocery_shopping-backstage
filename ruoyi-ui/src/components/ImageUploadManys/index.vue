<template>
  <div>
    <el-form ref="elForm" :model="formData"
             :rules="rules"
             size="medium"
             label-width="100px">
      <el-form-item label="上传" prop="field106">
        <el-upload ref="field106" :file-list="field106fileList" :action="field106Action" multiple
                   :before-upload="field106BeforeUpload" list-type="picture-card" accept="image/*">
          <i class="el-icon-plus"></i>
          <div slot="tip" class="el-upload__tip">只能上传不超过 2MB 的image/*文件</div>
        </el-upload>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
  export default {
    components: {},
    props: [],
    data() {
      return {
        formData: {
          field106: null,
        },
        rules: {},
        field106Action: 'https://jsonplaceholder.typicode.com/posts/',
        field106fileList: [],
      }
    },
    computed: {},
    watch: {},
    created() {},
    mounted() {},
    methods: {
      submitForm() {
        this.$refs['elForm'].validate(valid => {
          if (!valid) return
          // TODO 提交表单
        })
      },
      resetForm() {
        this.$refs['elForm'].resetFields()
      },
      field106BeforeUpload(file) {
        let isRightSize = file.size / 1024 / 1024 < 2
        if (!isRightSize) {
          this.$message.error('文件大小超过 2MB')
        }
        let isAccept = new RegExp('image/*').test(file.type)
        if (!isAccept) {
          this.$message.error('应该选择image/*类型的文件')
        }
        return isRightSize && isAccept
      },
    }
  }

</script>
<style>
  .el-upload__tip {
    line-height: 1.2;
  }

</style>
