package tomyjan.moeclassroommanager.controller.console;

import com.github.pagehelper.PageInfo;
import tomyjan.moeclassroommanager.common.annotation.Operation;
import tomyjan.moeclassroommanager.common.controller.BaseController;
import tomyjan.moeclassroommanager.common.exception.MessageException;
import tomyjan.moeclassroommanager.common.mybatis.condition.MybatisCondition;
import tomyjan.moeclassroommanager.common.utils.ReturnUtils;
import tomyjan.moeclassroommanager.domain.Room;
import tomyjan.moeclassroommanager.dto.RoomDTO;
import tomyjan.moeclassroommanager.service.FloorService;
import tomyjan.moeclassroommanager.service.RoomService;
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
@RequestMapping("/console/room")
public class RoomController extends BaseController {

    @Autowired
    private RoomService  roomService;
    @Autowired
    private FloorService floorService;

    @Operation("查看教学楼")
    @RequestMapping(value = "/index", method = {RequestMethod.GET})
    public String index(Model model) {
        return "console/room/index";
    }

    @Operation("教学楼详情")
    @RequestMapping(value = "detail/{id}", method = {RequestMethod.GET})
    public String from(@PathVariable Integer id, Model model) {
        Room room;
        if (id != 0) {
            room = roomService.selectByPrimaryKey(id);
        } else {
            room = new Room();
        }
        model.addAttribute("room", room);
        model.addAttribute("floorList", floorService.selectAll());
        return "console/room/detail";
    }

    @Operation("添加更新教学楼")
    @RequestMapping(value = "/merge", method = {RequestMethod.POST})
    public String save(@Valid Room room, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            throw new MessageException(result.getAllErrors().get(0).getDefaultMessage());
        }
        roomService.merge(room);
        return redirect("/console/room/index", "操作成功", attributes);
    }

    @Operation("删除教学楼")
    @RequestMapping(value = "/delete", method = {RequestMethod.GET})
    @ResponseBody
    public ModelMap delete(Integer id) {
        roomService.deleteByPrimaryKey(id);
        return ReturnUtils.success("操作成功", null, null);
    }

    @ResponseBody
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public ModelMap list(RoomDTO room) {
        ModelMap map = new ModelMap();
        MybatisCondition condition = new MybatisCondition()
                .like("r.name", room.getName())
                .like("f.name", room.getFloorName())
                .like("r.floor", room.getFloor())
                .page(room);
        PageInfo<RoomDTO> pageInfo = roomService.selectDtoPage(condition);
        map.put("pageInfo", pageInfo);
        return ReturnUtils.success("加载成功", map);
    }


}
