package tomyjan.moeclassroommanager.controller.console;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.annotation.Operation;
import tomyjan.moeclassroommanager.common.controller.BaseController;
import tomyjan.moeclassroommanager.common.exception.MessageException;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.common.utils.ReturnUtils;
import tomyjan.moeclassroommanager.domain.Classes;
import tomyjan.moeclassroommanager.domain.User;
import tomyjan.moeclassroommanager.dto.ClassesDTO;
import tomyjan.moeclassroommanager.service.ClassesService;
import tomyjan.moeclassroommanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("console/classes")
public class ClassesController extends BaseController {


    @Autowired
    private ClassesService classesService;
    @Autowired
    private UserService    userService;

    @Operation("查看班级列表")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/classes/index";
    }


    @Operation("班级详情")
    @RequestMapping(value = "/detail/{id}", method = {RequestMethod.GET})
    public String detail(@PathVariable Integer id, Model model) {
        Classes classes = classesService.selectByPrimaryKey(id);
        if (null == classes) {
            classes = new Classes();
        }
        model.addAttribute("classes", classes);
        model.addAttribute("userList", userService.select(new User().setType(User.UserTypeEnum.COUNSELOR)));
        return "console/classes/detail";
    }

    /**
     * 异步加载班级列表
     *
     * @param classes
     * @return
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(ClassesDTO classes) {
        ModelMap map = new ModelMap();
        MybatisCondition condition = new MybatisCondition()
                .like("c.name", classes.getName())
                .like("u.name", classes.getUserName());
        PageInfo<ClassesDTO> pageInfo = classesService.selectDtoPage(condition);
        map.put("pageInfo", pageInfo);
        return ReturnUtils.success("加载成功", map, null);
    }

    @Operation("更新班级信息")
    @RequestMapping(value = "/merge", method = {RequestMethod.POST})
    public String merge(@Valid Classes classes, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            throw new MessageException(result.getAllErrors().get(0).getDefaultMessage());
        }
        classesService.merge(classes);
        return redirect("/console/classes/index","修改成功", attributes);
    }

    @Operation("删除班级")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap delete(Integer id) {
        classesService.deleteByPrimaryKey(id);
        return ReturnUtils.success("删除成功", null, null);
    }
}
