package com.zzl.smartcommunitymanagement.controller;

import com.github.pagehelper.Page;
import com.zzl.smartcommunitymanagement.common.PageResult;
import com.zzl.smartcommunitymanagement.common.Result;
import com.zzl.smartcommunitymanagement.common.StatusCode;
import com.zzl.smartcommunitymanagement.domain.ScmTrade;
import com.zzl.smartcommunitymanagement.domain.ScmUser;
import com.zzl.smartcommunitymanagement.service.ScmTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trade")
public class ScmTradeController {

    @Autowired
    private ScmTradeService scmTradeService;

    /**
     * 创建一个未审核的闲置交易信息
     * @param session
     * @param request
     * @return Result
     */
    @RequestMapping("/create")
    @ResponseBody
    public Result createTrade(HttpSession session, @RequestBody Map request) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        LocalDateTime now = LocalDateTime.now();
        ScmTrade trade = new ScmTrade();
        trade.setCId(user.getUId());
        trade.setCTime(now);
        trade.setUTime(now);
        trade.setTState("0");
        if (StringUtil.isEmpty((String) request.get("name"))) {
            return new Result(false,StatusCode.ERROR,"商品名缺失，创建失败");
        }
        trade.setTName((String) request.get("name"));
        if (StringUtil.isEmpty((String) request.get("price"))) {
            return new Result(false,StatusCode.ERROR,"商品价格缺失，创建失败");
        }
        trade.setTPrice(Double.parseDouble((String) request.get("price")));
        if (StringUtil.isEmpty((String) request.get("quantity"))) {
            return new Result(false,StatusCode.ERROR,"商品数量缺失，创建失败");
        }
        trade.setTQuantity(Integer.parseInt((String) request.get("quantity")));
        scmTradeService.addTrade(trade);
        return new Result(true, StatusCode.OK,"创建成功，请等待审核!");
    }

    /**
     * 删除一个指定的闲置交易信息
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result deleteTrade(@RequestBody Map request) {
        if (StringUtil.isEmpty((String) request.get("id"))) {
            return new Result(false,StatusCode.ERROR,"删除失败！");
        }
        int id = Integer.parseInt((String) request.get("id"));
        scmTradeService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功！");
    }

    /**
     * 用户浏览所有可用的交易信息
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public PageResult findAll(@RequestBody Map searchMap) {
        Page<ScmTrade> allActive = scmTradeService.findAllActive(searchMap);
        return new PageResult(true,StatusCode.OK,"查询成功！",allActive, allActive.getTotal());
    }

    /**
     * 用户按条件筛选交易信息
     * @param searchMap
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public PageResult search(@RequestBody Map searchMap) {
        Page<ScmTrade> trades = scmTradeService.search(searchMap);
        return new PageResult(true,StatusCode.OK,"查询成功！",trades,trades.getTotal());
    }

    /**
     * 根据当前用户查找交易信息
     * @param session
     * @param searchMap
     * @return
     */
    @RequestMapping("/userTrade")
    @ResponseBody
    public PageResult userTrade(HttpSession session, @RequestBody Map searchMap) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        int uid = user.getUId();
        Page<ScmTrade> trades = scmTradeService.findByUserId(uid, searchMap);
        return new PageResult(true, StatusCode.OK, "查询成功！", trades, trades.getTotal());
    }

}
