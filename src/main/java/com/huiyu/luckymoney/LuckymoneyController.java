package com.huiyu.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: yanghao
 * @time: 2019/12/6 10:50
 */

@RestController
public class LuckymoneyController {
    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService luckymoneyService;
    /**
     * 获取红包列表
     * @return
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list(){
        return  repository.findAll();
    }

    /**
     * 创建红包（发红包）
     * @return
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /**
     * 通过id查询红包
     * @param id
     * @return
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更改红包（领红包）
     * @param id
     * @param consumer
     * @return
     */
    @PutMapping("luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("luckymoneys/two")
    public void createTwo(){
        luckymoneyService.createTwo();
    }
}
