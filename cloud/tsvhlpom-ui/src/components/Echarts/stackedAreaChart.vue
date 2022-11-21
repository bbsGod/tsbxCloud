<template>
  <el-card style="margin: 10px;margin-right: 10px">
    <div slot="header">
      <span class="text">{{title}}</span>
    </div>
    <div :id="id" :title="title" :legend="legend" :xAxixData="xAxixData" :yAxis="yAxis" :series="series"
         :style="{width:width,height:height,margin:margin,background:background}"></div>
  </el-card>

</template>

<script>
  import echarts from 'echarts'

  export default {
    name: "stackedAreaChart",
    props: {
      id: {
        type: String,
        default: "#linear"
      },
      title: {
        type: String
      },
      legend: {
        type: Array
      },
      xAxixData: {
        type: Array
      },
      yAxis: {
        type: Array
      },
      series: {
        type: Array
      },
      width: {
        type: String,
        default: "100%"
      },
      height: {
        type: String,
        default: "350px"
      },
      margin: {
        type: String,
        default: "0 auto"
      },
      background: {
        type: String,
        default: "white"
      }
    },
    data() {
      return {
        charts: undefined,
      }
    },
    watch: {
      xAxixData: {
        handler(newValue, oldValue) {
          this.updateChart();
        },
        deep: true
      }
    },
    mounted() {
      this.drawChart()
    },
    methods: {
      drawChart() {
        let _this = this;
        this.charts = echarts.init(document.getElementById(this.id));
        this.charts.setOption({
          legend: {
            data: this.legend
          },
          grid: {
            left: '2%',
            right: '2%',
            bottom: '2%',
            containLabel: true
          },
          xAxis: {
            type: 'category',
            boundaryGap: false,
            data: this.xAxixData,
          },
          yAxis: this.yAxis,
          series: this.series,
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross',
              label: {
                backgroundColor: '#6a7985'
              }
            }
          },
        })
        window.addEventListener("resize", function () {
          _this.charts.resize();
        })
      },
      updateChart() {
        this.charts.setOption({
          xAxis: {
            data: this.xAxixData
          },
          series: this.series,
        })
      }
    },
    beforeDestroy() {
      if (this.charts) {
        this.charts.clear();
      }
    }

  }
</script>

<style scoped>
  .text {
    font-size: 20px;
    font-weight: 500;
  }
</style>
