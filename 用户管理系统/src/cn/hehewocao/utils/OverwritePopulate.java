package cn.hehewocao.utils;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.util.Date;
import java.util.Map;

public class OverwritePopulate {
    public static void transMap2Bean(Map<String, String[]> map, Object obj) {

        try {
            DateTimeConverter dtConverter = new DateTimeConverter();
            ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
            convertUtilsBean.deregister(Date.class);
            convertUtilsBean.register(dtConverter, Date.class);
            BeanUtilsBean beanUtilsBean = new BeanUtilsBean(convertUtilsBean,
                    new PropertyUtilsBean());
            beanUtilsBean.populate(obj, map);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return;

    }
}
