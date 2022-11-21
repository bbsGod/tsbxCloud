

<template style="background: #cccccc">

    <div :yname="yname" :ytype="ytype"  :title="title" :xAxisData="xAxisData" :yAxisData1="yAxisData1" :yAxisData2="yAxisData2" :id="id" :legend="legend"  :style="{width:width,height:height,background:background,margin:margin}">
    </div>

</template>
<script>

    import echarts from 'echarts'
    export default {
        props:{
            width:{
              type:String,
                default:"98%"
            },
            height: {
              type:String,
              default:"350px"
            },
          yname:{
            type:String,
            default:""
          },
          margin:{
            type:String,
            default:"0 auto"
          },
          background:{
              type:String,
            default:"white"
          },

            id:{
              type:String,
                default:"#bilinear"
            },
            xAxisData:{
                type:Array
            },
            yAxisData1:{
                type:Array
            } ,
            yAxisData2:{
                type:Array
            },
            legend:{
                type:Array
            },
            title:{
                type:String,
            },
            yAxisColor1: {
                type:String,
                default:'#6EACDE',
            },
            yAxisColor2: {
                type:String,
                default:'#6CC272',
            },
          ytype:{
              type:String,
            default:"value"
          }
        },
        data(){
            return {
                chartColumn: null,
            }
        },
        mounted() {
            this.drawLine1()
        },
        methods: {
            drawLine1(){
                this.chartColumn = echarts.init(document.getElementById(this.id));
                this.chartColumn.setOption({
                    title: {
                      text: this.title,
                      textVerticalAlign:'middle',
                      bottom:'5',
                      textStyle: {
                        fontWeight:'normal',
                        fontSize:14,
                        lineHeight:0
                      },
                      left:'center'
                    },
                    tooltip: {
                        trigger: 'axis',
                    },
                    legend: {
                        data: this.legend
                    },
                    grid: {
                      left: '2%',
                      right: '2%',
                      top:'15%',
                      bottom:'15%',
                      containLabel: true
                    },
                    toolbox: {
                        feature: {
                        }
                    },
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,
                        data: this.xAxisData,
                    },
                    yAxis: {
                      name:this.yname,
                        type: this.ytype,
                      splitLine:{//y虚线设置
                        show:true,
                        lineStyle:{
                          type:'dashed'
                        }

                      }
                    },
                    series: [
                        {
                            name: this.legend[0],
                            type: 'line',
                            symbol: "none",
                          smooth:'none',
                            color:this.yAxisColor1,
                            data: this.yAxisData1,
                        },
                        {
                            name: this.legend[1],
                            type: 'line',
                            symbol: "none",
                          smooth:'none',
                            color:this.yAxisColor2,
                            data: this.yAxisData2,

                        }
                    ]

                },true);
            },

        },
      watch:{
        xAxisData:{
          handler(newValue,oldValue){
            this.xAxisData=newValue;
            this.drawLine1();
          }
        },
        yAxisData1:{
          handler(newValue,oldValue){
            this.yAxisData1=newValue;
            this.drawLine1();
          }
        },
        yAxisData2:{
          handler(newValue,oldValue){
            this.yAxisData2=newValue;
            this.drawLine1();
          }
        },
        deep:true
      }
    }
</script>

