package com.dubbo.entity.converter;

import com.dubbo.entity.EnableDisableStatus;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;

/**
 * Created by JSH on 2014/12/27.
 */
public class EnableDisableStatusConverter implements AttributeConverter<EnableDisableStatus, Integer>, Converter<String, EnableDisableStatus> {
    @Override
    public Integer convertToDatabaseColumn(EnableDisableStatus enableDisableStatus) {
        return enableDisableStatus.getValue();
    }

    @Override
    public EnableDisableStatus convertToEntityAttribute(Integer i) {
        return EnableDisableStatus.get(i);
    }

    @Override
    public EnableDisableStatus convert(String s) {
        return EnableDisableStatus.get(Integer.parseInt(s));
    }
}
