<template>



    <div :id="id"  :legen="legen" :xAxisData="xAxisData" :yAxisData1="yAxisData1" :yAxisData2="yAxisData2" :yAxisColor1="yAxisColor1" :yAxisColor2="yAxisColor2" :style="{width:width,height:height}"></div>
</template>
<script>
    import echarts from 'echarts'
    export default {
        props:{
            id:{
                type:String,
                default:"#fuliear"
            }
            ,
            width:{
                type:String,
                default:"100%"
            },
            height: {
                type:String,
                default:"350px"
            },
            legen: {
                type:Array,
            },
            xAxisData:{
                type:Array,
            },
            yAxisData1:{
                type:Array,
            },
            yAxisData2:{
                type:Array,
            },
            yAxisColor1:{
                type:String,
                default:"#6EACDE"
            },
            yAxisColor2:{
                type:String,
                default:"#FBE488"
            }

        },
        data(){
            return {
                chartColumn: null,
                customColor: '#409eff',
                customColors: {color:"#f56c6c",percentage: 20}
            }
        },
        mounted() {
            this. drawLine1();
        },

        methods: {
            //线程图
            drawLine1(){
                this.chartColumn = echarts.init(document.getElementById(this.id));
                this.chartColumn.setOption({

                    title: {
                    },

                    legend: {
                        data: [{name:this.legen[0],icon:'rect',value:20}, {name:this.legen[1],icon:'rect',value:30}],

                        formatter: function(series){

                            return series
                        }
                    },
                    toolbox: {
                    },
                    grid: {
                        left: '6%',
                        right: '1%',
                        bottom: '20%',
                        containLabel: false
                    },
                    xAxis: [
                        {
                            type: 'category',
                            boundaryGap: false,
                            data: this.xAxisData
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [

                        {
                            name: '守护线程',
                            type: 'line',
                            //圆点
                            symbol: "none",
                            stack: '总量',
                            //smooth: true, 曲线
                            areaStyle: {
                            },
                            color:this.yAxisColor1,
                            label: {
                                normal: {
                                    show: false,
                                    position: 'center',
                                    color:this.yAxisColor1
                                },
                            },
                            data: this.yAxisData1
                        },
                        {
                            name: '活跃线程',
                            type: 'line',
                            symbol: "none",
                            stack: '总量',
                            color:this.yAxisColor2,
                            //smooth: true,
                            label: {
                                normal: {
                                    show: true,
                                    position: 'top',
                                    color:this.yAxisColor2
                                }
                            },
                            areaStyle: {

                            },
                            data: this.yAxisData2
                        }
                    ]

                });
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
