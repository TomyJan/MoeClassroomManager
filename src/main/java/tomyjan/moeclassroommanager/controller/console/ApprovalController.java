package tomyjan.moeclassroommanager.controller.console;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.annotation.Operation;
import tomyjan.moeclassroommanager.common.controller.BaseController;
import tomyjan.moeclassroommanager.common.exception.MessageException;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.common.utils.ReturnUtils;
import tomyjan.moeclassroommanager.domain.Approval;
import tomyjan.moeclassroommanager.dto.ApprovalDTO;
import tomyjan.moeclassroommanager.service.ApprovalService;
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

/**
 * 审批管理
 */
@Controller
@RequestMapping("console/approval")
public class ApprovalController extends BaseController {

    @Autowired
    private ApprovalService approvalService;

    @Operation("查看审批列表")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/approval/index";
    }

    /**
     * 异步加载列表
     *
     * @param approval
     * @return
     */
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap list(ApprovalDTO approval) {
        ModelMap map = new ModelMap();
        MybatisCondition condition = new MybatisCondition()
                .like("u.name", approval.getUserName())
                .like("f.name", approval.getFloorName())
                .order("a.id", false);
        PageInfo<ApprovalDTO> pageInfo = approvalService.selectDtoPage(condition);
        map.put("pageInfo", pageInfo);
        return ReturnUtils.success("加载成功", map, null);
    }

    @Operation("更新审批")
    @RequestMapping(value = "/merge", method = {RequestMethod.POST})
    public String merge(@Valid Approval approval, BindingResult result, RedirectAttributes attributes) {
        try {
            if (result.hasErrors()) {
                throw new MessageException(result.getAllErrors().get(0).getDefaultMessage());
            }
            approvalService.merge(approval);
            return refresh("操作成功", attributes);
        } catch (Exception e) {
            throw new MessageException(e.getMessage());
        }
    }

    @Operation("审批详情")
    @RequestMapping(value = "/detail/{id}", method = {RequestMethod.GET})
    public String detail(@PathVariable Integer id, Model model) {
        Approval approval = approvalService.selectByPrimaryKey(id);
        if (null == approval) {
            approval = new Approval();
        }
        model.addAttribute("approval", approval);
        return "console/approval/detail";
    }

}
