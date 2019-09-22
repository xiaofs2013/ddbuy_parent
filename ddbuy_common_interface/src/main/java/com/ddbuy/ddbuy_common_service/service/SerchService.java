package com.ddbuy.ddbuy_common_service.service;

import java.util.List;
import java.util.Properties;

public interface SerchService {

    //导入数据到Solr索引库  不需要返回List结果 因为没有需要他展示的地方 这只是个导入操作
    public boolean PropertiesImporToSolr();

}
