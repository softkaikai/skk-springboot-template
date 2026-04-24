package org.example.springboot3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author kaikai
 * @since 2026-04-23
 */
@Data
@TableName("product")
@Schema(name = "Product", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Schema(description = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField("name")
    @Schema(description = "名称")
    private String name;

    /**
     * 描述
     */
    @TableField("description")
    @Schema(description = "描述")
    private String description;

    /**
     * 价格
     */
    @TableField("price")
    @Schema(description = "价格")
    private Double price;

    /**
     * 库存
     */
    @TableField("inventory")
    @Schema(description = "库存")
    private Integer inventory;

    /**
     * 销售量
     */
    @TableField("sold")
    @Schema(description = "销售量")
    private Integer sold;

    /**
     * 图片
     */
    @TableField("imgUrl")
    @Schema(description = "图片")
    private String imgUrl;

    /**
     * 分类id
     */
    @TableField("categoryId")
    @Schema(description = "分类id")
    private Integer categoryId;
}
