package com.nowui.chuangshi.api.member.admin;

import com.jfinal.aop.Before;
import com.jfinal.core.ActionKey;
import com.nowui.chuangshi.api.member.service.MemberAddressService;
import com.nowui.chuangshi.common.annotation.ControllerKey;
import com.nowui.chuangshi.common.controller.Controller;
import com.nowui.chuangshi.common.interceptor.AdminInterceptor;

@Before(AdminInterceptor.class)
@ControllerKey("/admin/member/address")
public class MemberAddressController extends Controller {

    private final MemberAddressService memberAddressService = MemberAddressService.me;

    @ActionKey("/admin/member/address/list")
    public void list() {

        renderSuccessJson();
    }

    @ActionKey("/admin/member/address/find")
    public void find() {

        renderSuccessJson();
    }

    @ActionKey("/admin/member/address/save")
    public void save() {

        renderSuccessJson();
    }

    @ActionKey("/admin/member/address/update")
    public void update() {

        renderSuccessJson();
    }

    @ActionKey("/admin/member/address/delete")
    public void delete() {

        renderSuccessJson();
    }

}