package practice.zank.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @TableName article
 */
@TableName(value = "article")
@Data
public class Article implements Serializable {
    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    @NotNull(groups = {Update.class})
    private Integer id;
    /**
     * 文章标题
     */
    @TableField(value = "title")
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;
    /**
     * 文章内容
     */
    @TableField(value = "content")
    @NotEmpty
    private String content;
    /**
     * 文章封面
     */
    @TableField(value = "cover_img")
    @URL
    @NotEmpty
    private String coverImg;
    /**
     * 文章状态: 只能是[已发布] 或者 [草稿]
     */
    @TableField(value = "state")
    @Pattern(regexp = "^(已发布|草稿)$")
    private String state;
    /**
     * 文章分类ID
     */
    @TableField(value = "category_id")
    @NotNull
    private Integer categoryId;
    /**
     * 创建人ID
     */
    @TableField(value = "create_user")
    private Integer createUser;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public interface Update extends Default {}
}