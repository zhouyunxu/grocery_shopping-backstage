<template>
  <div class="loginzhong">

  <!--<h1>
    小农村里小民房，小民房里小民工；小民工人写程序，又拿代码讨赏钱。<br/>
    钱空只在代码中，钱醉仍在代码间；有钱无钱日复日，码上码下年复年。<br/>
    但愿老死代码间，不愿鞠躬奥迪前，奥迪奔驰贵者趣，程序代码贫者缘。<br/>
    若将贫贱比贫者，一在平地一在天；若将贫贱比车马，他得驱驰我得闲。<br/>
    别人笑我忒疯癫，我笑他人看不穿；不见盖茨两手间，财权富贵世人鉴。
  </h1>-->

    <h1>欢迎来到杂货店!</h1>

    <template>
<!--      <el-carousel :interval="4000" type="card" height="200px">-->
<!--        &lt;!&ndash;<img v-for="(src,index) in goodList" :src="src.goodUrl" :key="index">&ndash;&gt;-->
<!--        <img v-for="(src,index) in img" :src="src" :key="index">-->
<!--        <el-carousel-item v-for="(src,index) in img" :src="src" :key="index">-->
<!--&lt;!&ndash;          <h3 class="medium">{{ index }}</h3>&ndash;&gt;-->
<!--        </el-carousel-item>-->

<!--      </el-carousel>-->

      <el-carousel :interval="4000" type="card" height="400px">
        <el-carousel-item v-for="(src,index) in img" :key="item">
          <img :src="src" height="400px"/>
        </el-carousel-item>
      </el-carousel>
    </template>


</div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      // 版本号
      version: "3.5.0",
      img : ["http://106.55.20.172/profile/upload/2022/05/26/6eca1fa8-8b50-4503-b8ce-f5b4e773b8b5.jpg",
    "http://106.55.20.172/profile/upload/2022/06/20/4c39301b-5a9f-4724-8a17-ffb3e632ba65.jpg",
      "http://106.55.20.172/profile/upload/2022/06/20/f4d9c204-f05d-43c4-bc8e-02942f7d245e.jpg"]
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
  .loginzhong{
    text-align: center;
  }


.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}

  //走马灯
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    //background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    //background-color: #d3dce6;
  }


</style>

