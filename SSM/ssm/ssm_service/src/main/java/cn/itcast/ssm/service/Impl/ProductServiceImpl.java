package cn.itcast.ssm.service.Impl;

import cn.itcast.ssm.dao.IProductDao;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;
    
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
