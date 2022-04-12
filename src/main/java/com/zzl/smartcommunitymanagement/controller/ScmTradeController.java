package com.zzl.smartcommunitymanagement.controller;

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

import javax.servlet.http.HttpSession;
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
    public Result createTrade(HttpSession session, @RequestBody Map<String,String> request) {
        ScmUser user = (ScmUser) session.getAttribute("user");
        Date now = new Date();
        ScmTrade trade = new ScmTrade();
        trade.setCId(user.getUId());
        trade.setCTime(now);
        trade.setUTime(now);
        trade.setTState("0");
        if (request.get("name") == null) {
            return new Result(false,StatusCode.ERROR,"商品名缺失，创建失败");
        }
        trade.setTName(request.get("name"));
        if (request.get("price") == null) {
            return new Result(false,StatusCode.ERROR,"商品价格缺失，创建失败");
        }
        trade.setTPrice(Double.valueOf(request.get("price")));
        if (request.get("quantity") == null) {
            return new Result(false,StatusCode.ERROR,"商品数量缺失，创建失败");
        }
        trade.setTQuantity(Integer.valueOf(request.get("quantity")));
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
    public Result deleteTrade(@RequestBody Map<String,String> request) {
        if (request.get("id") == null) {
            return new Result(false,StatusCode.ERROR,"删除失败！");
        }
        int id = Integer.parseInt(request.get("id"));
        scmTradeService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功！");
    }

    /**
     * 用户浏览所有可用的交易信息
     * @return
     */
    public PageResult findAll() {
        List<ScmTrade> allActive = scmTradeService.findAllActive(0,0);
        return new PageResult(true,StatusCode.OK,"查询成功！",allActive, (long) allActive.size());
    }

    public PageResult search(@RequestBody Map searchMap) {
        return new PageResult(true,StatusCode.OK,"查询成功！",null,0l);
    }

}
