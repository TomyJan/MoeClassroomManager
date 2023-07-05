package tomyjan.moeclassroommanager.controller.site;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.annotation.Operation;
import tomyjan.moeclassroommanager.common.controller.BaseController;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.common.utils.ReturnUtils;
import tomyjan.moeclassroommanager.domain.Message;
import tomyjan.moeclassroommanager.domain.Room;
import tomyjan.moeclassroommanager.dto.MessageDTO;
import tomyjan.moeclassroommanager.dto.RoomDTO;
import tomyjan.moeclassroommanager.service.FloorService;
import tomyjan.moeclassroommanager.service.MessageService;
import tomyjan.moeclassroommanager.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("message")
public class MessageController extends BaseController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private FloorService floorService;
    @Autowired
    private RoomService roomService;

    @Operation("查看留言列表")
    @RequestMapping(value = "/index", method = { RequestMethod.GET })
    public String index(Model model) {
        MybatisCondition condition = new MybatisCondition().eq("f.user_id", loginUser().getId()).order("m.id", false);
        PageInfo<MessageDTO> pageInfo = messageService.selectDtoPage(condition);
        model.addAttribute(pageInfo);
        return "site/message/index";
    }

    /**
     * 留言
     */
    @GetMapping("send")
    public String send(Model model) {
        model.addAttribute("floorList", floorService.selectAll());
        return "site/message/send";
    }

    /**
     * 提交留言
     *
     * @param message
     * @param attributes
     *
     * @return
     */
    @PostMapping("send")
    public String send(Message message, RedirectAttributes attributes) {
        message.setUserId(loginUser().getId());
        messageService.insertSelective(message);
        return refresh("提交成功", attributes);
    }

    @ResponseBody
    @RequestMapping(value = "/roomList", method = { RequestMethod.GET })
    public ModelMap list(RoomDTO room) {
        ModelMap map = new ModelMap();
        map.put("list", roomService.select(new Room().setFloorId(room.getFloorId())));
        return ReturnUtils.success("加载成功", map);
    }

}
