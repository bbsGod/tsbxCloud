<template>
  <div>
    <div v-if="covidFlag">
      <HomePage></HomePage>
    </div>
    <div v-else-if="cargroupFlag" style="text-align: center">
      <img src="../assets/images/cargroup.jpg" style="height: 850px;object-fit:cover ">
    </div>
    <div v-else class="app-container home p" style="text-align: center">
      <p>欢迎使用泰山保险系统</p>
    </div>
  </div>
</template>
<script>
import HomePage from '@/views/covid/HomePage'
import {authRole} from '@/plugins/auth'
export default {
  name: "Index",
  components: { HomePage },
  data() {
    return {
      // 版本号
      version: "3.2.0",
      covidFlag: false,
      cargroupFlag: false,
    };
  },
  created() {
    if(authRole("covid")){
      this.covidFlag = true;
    }else{
      this.covidFlag = false;
    }
    if(authRole("cargroup") || authRole("cargroup_visit") || authRole("cargroup_delete")){
      this.cargroupFlag = true;
    }else{
      this.cargroupFlag = false;
    }
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss" rel="stylesheet/scss">
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  background-image: url("../assets/images/cargroup.jpg");
  background-size: cover;
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
  font-size: 44px;
  color: #030303;
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
</style>

