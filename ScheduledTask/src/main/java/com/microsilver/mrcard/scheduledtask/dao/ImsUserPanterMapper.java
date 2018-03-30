package com.microsilver.mrcard.scheduledtask.dao;

import com.microsilver.mrcard.scheduledtask.model.ImsUserPanter;
import com.microsilver.mrcard.scheduledtask.model.ImsUserPanterExample;
import java.util.List;

public interface ImsUserPanterMapper {

    List<ImsUserPanter> selectByExample(ImsUserPanterExample example);

    ImsUserPanter selectByPrimaryKey(Long id);
}