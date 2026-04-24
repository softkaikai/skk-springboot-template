package org.example.springboot3.service.impl;

import org.example.springboot3.entity.Product;
import org.example.springboot3.mapper.ProductMapper;
import org.example.springboot3.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kaikai
 * @since 2026-04-23
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

}
