package com.dubbo.entity.converter;

import com.dubbo.entity.YesNoStatus;
import org.springframework.core.convert.converter.Converter;

import javax.persistence.AttributeConverter;

/**
 * Created by lkp on 16-10-10.
 */
public class YesNoStatusConverter implements AttributeConverter<YesNoStatus, Integer>, Converter<String, YesNoStatus> {

    @Override
    public Integer convertToDatabaseColumn(YesNoStatus yesNoStatus) {
        return yesNoStatus.getValue();
    }

    @Override
    public YesNoStatus convertToEntityAttribute(Integer integer) {
        return YesNoStatus.get(integer);
    }

    @Override
    public YesNoStatus convert(String s) {
        return YesNoStatus.get(Integer.parseInt(s));
    }
}
