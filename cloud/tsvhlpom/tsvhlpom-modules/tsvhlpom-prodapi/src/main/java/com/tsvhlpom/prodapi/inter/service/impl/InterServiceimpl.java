package com.tsvhlpom.prodapi.inter.service.impl;

import com.tsvhlpom.prodapi.constant.FlatConstant;
import com.tsvhlpom.prodapi.constant.SubComDptCde;
import com.tsvhlpom.prodapi.inter.VO.InterResVO;
import com.tsvhlpom.prodapi.inter.mapper.InterMapper;
import com.tsvhlpom.prodapi.inter.service.InterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class InterServiceimpl implements InterService {

    @Autowired
    private InterMapper interMapper;
    @Override
    public List<InterResVO> getInfo(String id, Date startDate, Date endDate) throws Exception {

        List<InterResVO> interResVOList = interMapper.getInfo(id,startDate,endDate);
        log.info("获取数据成功，总条数："+interResVOList.size()+"条");
        for(InterResVO interResVO: interResVOList){
            interResVO.setCUsageCde(this.getMotorUsageTypeCode(interResVO));
            interResVO.setCvrgList(interMapper.getCvrg(interResVO.getCAppNo()));
        }
        log.info("处理使用性质完成");
        return interResVOList;
    }

    public String getMotorUsageTypeCode(InterResVO interResVO) throws Exception
    {
        String c_class ="";
        String code="";
        String rcode="";//返回值；
        String vhlTyp = interResVO.getCVhlTyp();   //车辆种类
        String usageCde = interResVO.getCUsageCde();  //车辆使用性质
        if(FlatConstant.PROD_0336.equals(interResVO.getCProdNo()) ||FlatConstant.PROD_0332.equals(interResVO.getCProdNo()))
        {
            if("365014".equals(vhlTyp) || "365015".equals(vhlTyp) || "365016".equals(vhlTyp) || "365017".equals(vhlTyp))  //判断是挂车的时候
            {
                if("374010".equals(usageCde))   // 使用性质营业货车
                {
                    return "106";    //平台代码营业挂车
                } else if("374004".equals(usageCde)) //使用性质非营业货车
                {
                    return "250"; // 平台非营业挂车
                }
            }
            c_class = "2104";
            code = usageCde;
        } else if (FlatConstant.PROD_0339.equals(interResVO.getCProdNo()))
        {
            code = interResVO.getCVhlcategoryCde();
            c_class = "1301";
        } else if (FlatConstant.PROD_0320.equals(interResVO.getCProdNo())){

            if ("365018".equals(vhlTyp)) { //交强低速载货汽车传000
                return "000";
            }

            String usageCde0320 = interResVO.getCUsageCde();  //车辆使用性质
            c_class = "2104";
            code = usageCde0320;
            if("364005001".equals(usageCde0320)){//0320特种车
                code = interResVO.getCVhlcategoryCde();
                c_class = "1301";
            }

            if (interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_BJ) || interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_NB)
                    ||interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_SD) || interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_JS)	) {
                //北京 投保交强险时，特种车、摩托车、拖拉机必须使用该车辆使用性质代码
                if ("364005001".equals(usageCde0320) || "364005002".equals(usageCde0320) || "364005003".equals(usageCde0320)) {
                    return "000";
                }
            }
        } else if (FlatConstant.PROD_0335.equals(interResVO.getCProdNo())) {
            if (interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_BJ) ||interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_NB)) {
                if ("374016".equals(usageCde)) { // 摩托车
                    return "000";
                } else { // 拖拉机
                    code = interResVO.getCVhlcategoryCde();
                    if ("VHL007".equals(code) || "VHL008".equals(code)) { // 兼用型
                        return "310";
                    } else if ("VHL009".equals(code) || "VHL010".equals(code)) { // 运输型
                        return "320";
                    }
                }
            }
        } else if (FlatConstant.PROD_0337.equals(interResVO.getCProdNo())) {
            if (interResVO.getCDptCde().startsWith(SubComDptCde.SUB_COM_DPT_BJ)) {
                if("365014".equals(vhlTyp) || "365015".equals(vhlTyp) || "365016".equals(vhlTyp) || "365017".equals(vhlTyp))  //判断是挂车的时候
                {
                    if("374010".equals(usageCde))   // 使用性质营业货车
                    {
                        return "106";    //平台代码营业挂车
                    } else if("374004".equals(usageCde)) //使用性质非营业货车
                    {
                        return "250"; // 平台非营业挂车
                    }
                }
                c_class = "2104";
                code = usageCde;
            }
        }

        if(code == null || "".equals(code)) {
            return "";
        }
        return interMapper.getFlatUsageCode(c_class,code);
    }
}
