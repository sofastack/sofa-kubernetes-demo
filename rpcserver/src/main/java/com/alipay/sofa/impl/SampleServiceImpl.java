package com.alipay.sofa.impl;

import com.alipay.sofa.facade.SampleModel;
import com.alipay.sofa.facade.SampleService;

public class SampleServiceImpl implements SampleService {
    @Override
    public SampleModel hello() {
        SampleModel sampleModel = new SampleModel();
        sampleModel.setWord("Hello");
        return sampleModel;
    }
}
