/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.bodribakery.controllers;

import hu.elte.bodribakery.entities.User;
import hu.elte.bodribakery.entities.customized.CustomizedRec;
import hu.elte.bodribakery.entities.customized.CustomizedReceipt;
import hu.elte.bodribakery.repositories.ReceiptRepository;
import hu.elte.bodribakery.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
/**
 *
 * @author stefa
 */
public class ReceiptController {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/rec/id")
    public List<CustomizedReceipt> getVisibleReceipts() {
        return receiptRepository.findVisibleReceipts();
    }
    /*@GetMapping("/rec/{id}")
    public CustomizedReceipt get(@PathVariable int id){
        return (receiptRepository.findByMyId(id));
    }*/
    @GetMapping("/rec")
    public List<CustomizedRec>getRecUse(){
        ArrayList<CustomizedRec> helpp=new ArrayList();
        for (User seged:userRepository.findAll()) {
            helpp.add(new CustomizedRec(seged.getId(),seged.getNickname(),receiptRepository.findByUserId(seged.getId())));
        }
        return helpp;

    }
}