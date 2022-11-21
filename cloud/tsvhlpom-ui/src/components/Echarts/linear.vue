

<template style="background: #cccccc">
            <div :yname="yname" :id="id" :title="title" :xAxisData="xAxisData" :yAxisData="yAxisData" :color="color"   :style="{width:width,height:height,margin:margin,background:background}">
            </div>
</template>
<script>

    import echarts from 'echarts'
    export default {
        props:{
            width:{
                type:String,
                default:"100%"
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
                default: "#linear"
            }
            ,
            title:{
                type:String
            },
            xAxisData:{
                type:Array
            },
            yAxisData:{
                type:Array
            },
            color:{
                type:String,
                default:"#6EACDE"
            }

        },

        data(){
            return {
                chartColumn: null,
            }
        },
        mounted() {
            this.drawLine();
        },

        methods: {
            drawLine(){
                this.chartColumn = echarts.init(document.getElementById(this.id));
                this.chartColumn.setOption({
                    title:{
                        text:this.title,
                        textVerticalAlign:'middle',
                        bottom:'5',
                        textStyle: {
                        fontWeight:'normal',
                        fontSize:14,
                        lineHeight:0
                      },
                      left:'center'
                    },legend: {
                        data: this.title
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    grid:{
                        left: '5%',
                        right:'5%',
                        top:'10%'
                    }
                    ,
                    xAxis: {
                        type: 'category',
                        boundaryGap: false,

                        data: this.xAxisData
                    },
                    yAxis: {
                      name:this.yname,
                        show: true,
                        axisLine:{
                            show:false
                        }
                        ,
                      splitLine:{//y虚线设置
                        show:true,
                        lineStyle:{
                          type:'dashed'
                        }

                      },

                        smooth:false,
                    },
                    series: [
                        {
                            name: this.title,
                            type: 'line',
                            smooth: true,//拐点是否显示
                            symbol:'circle',//拐点设置为实心
                            symbolSize:5,//拐点大小
                            animation:false,//拐点是否放大
                            stack: '访问量',
                            color:this.color,
                            lineStyle:{
                                color:this.color
                            },

                            itemStyle:{
                                color:this.color
                            },
                            data: this.yAxisData
                        }
                    ]
                });
            },
        }
        ,
        watch:{
          xAxisData:{
            handler(newValue,oldValue){
              if(newValue===undefined){
                this.xAxisData=[];

              }else{
                this.xAxisData=newValue;
              }
              this.drawLine();
            }
          },
          yAxisData:{
            handler(newValue,oldValue){
              if(newValue===undefined){
                this.yAxisData=[];
              }else{
                this.yAxisData=newValue;
              }
              this.drawLine();
            }
          },

          deep:true
        }



    }
</script>
