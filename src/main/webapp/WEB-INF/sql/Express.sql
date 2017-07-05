#namespace("express")

  #sql("countByApp_idOrLikeExpress_no")
    SELECT COUNT(*) FROM table_express
    WHERE system_status = 1
    AND app_id = #p(app_id)
    #if(express_no)
    #set(express_no = "%" + express_no + "%")
    AND express_no LIKE #p(express_no)
    #end
  #end

  #sql("countByOrApp_idOrLikeExpress_no")
    SELECT COUNT(*) FROM table_express
    WHERE system_status = 1
    #if(app_id)
    AND app_id = #p(app_id)
    #end
    #if(express_no)
    #set(express_no = "%" + express_no + "%")
    AND express_no LIKE #p(express_no)
    #end
  #end

  #sql("listByApp_idAndSystem_create_timeAndLimit")
    SELECT
    express_id
    FROM table_express
    WHERE system_status = 1
    AND app_id = #p(app_id)
    AND system_create_time < UNIX_TIMESTAMP(#p(system_create_time))
    ORDER BY system_create_time DESC
    LIMIT #p(m), #p(n)
  #end

  #sql("listByApp_idOrLikeExpress_noAndLimit")
    SELECT
    express_id
    FROM table_express
    WHERE system_status = 1
    AND app_id = #p(app_id)
    #if(express_no)
    #set(express_no = "%" + express_no + "%")
    AND express_no LIKE #p(express_no)
    #end
    ORDER BY system_create_time DESC
    LIMIT #p(m), #p(n)
  #end

  #sql("listByOrApp_idOrLikeExpress_noAndLimit")
    SELECT
    express_id
    FROM table_express
    WHERE system_status = 1
    #if(app_id)
    AND app_id = #p(app_id)
    #end
    #if(express_no)
    #set(express_no = "%" + express_no + "%")
    AND express_no LIKE #p(express_no)
    #end
    ORDER BY system_create_time DESC
    LIMIT #p(m), #p(n)
  #end

  #sql("findByExpress_id")
    SELECT
    *
    FROM table_express
    WHERE system_status = 1
    AND express_id = #p(express_id)
  #end

  #sql("save")
    INSERT INTO table_express (
      express_id,
      app_id,
      trade_id,
      member_stock_action_id,
      express_shipper_code,
      express_no,
      express_type,
      express_receiver_company,
      express_receiver_name,
      express_receiver_tel,
      express_receiver_mobile,
      express_receiver_postcode,
      express_receiver_province,
      express_receiver_city,
      express_receiver_area,
      express_receiver_address,
      express_sender_company,
      express_sender_name,
      express_sender_tel,
      express_sender_mobile,
      express_sender_postcode,
      express_sender_province,
      express_sender_city,
      express_sender_area,
      express_sender_address,
      express_cost,
      express_is_pay,
      express_pay_way,
      express_start_date,
      express_end_date,
      express_remark,
      system_create_user_id,
      system_create_time,
      system_update_user_id,
      system_update_time,
      system_version,
      system_status
    ) VALUES (
      #p(express_id),
      #p(app_id),
      #p(trade_id),
      #p(member_stock_action_id),
      #p(express_shipper_code),
      #p(express_no),
      #p(express_type),
      #p(express_receiver_company),
      #p(express_receiver_name),
      #p(express_receiver_tel),
      #p(express_receiver_mobile),
      #p(express_receiver_postcode),
      #p(express_receiver_province),
      #p(express_receiver_city),
      #p(express_receiver_area),
      #p(express_receiver_address),
      #p(express_sender_company),
      #p(express_sender_name),
      #p(express_sender_tel),
      #p(express_sender_mobile),
      #p(express_sender_postcode),
      #p(express_sender_province),
      #p(express_sender_city),
      #p(express_sender_area),
      #p(express_sender_address),
      #p(express_cost),
      #p(express_is_pay),
      #p(express_pay_way),
      #p(express_start_date),
      #p(express_end_date),
      #p(express_remark),
      #p(system_create_user_id),
      #p(system_create_time),
      #p(system_update_user_id),
      #p(system_update_time),
      #p(system_version),
      #p(system_status)
    )
  #end

  #sql("update")
    UPDATE table_express SET
    trade_id = #p(trade_id),
    member_stock_action_id = #p(member_stock_action_id),
    express_shipper_code = #p(express_shipper_code),
    express_no = #p(express_no),
    express_type = #p(express_type),
    express_receiver_company = #p(express_receiver_company),
    express_receiver_name = #p(express_receiver_name),
    express_receiver_tel = #p(express_receiver_tel),
    express_receiver_mobile = #p(express_receiver_mobile),
    express_receiver_postcode = #p(express_receiver_postcode),
    express_receiver_province = #p(express_receiver_province),
    express_receiver_city = #p(express_receiver_city),
    express_receiver_area = #p(express_receiver_area),
    express_receiver_address = #p(express_receiver_address),
    express_sender_company = #p(express_sender_company),
    express_sender_name = #p(express_sender_name),
    express_sender_tel = #p(express_sender_tel),
    express_sender_mobile = #p(express_sender_mobile),
    express_sender_postcode = #p(express_sender_postcode),
    express_sender_province = #p(express_sender_province),
    express_sender_city = #p(express_sender_city),
    express_sender_area = #p(express_sender_area),
    express_sender_address = #p(express_sender_address),
    express_cost = #p(express_cost),
    express_is_pay = #p(express_is_pay),
    express_pay_way = #p(express_pay_way),
    express_start_date = #p(express_start_date),
    express_end_date = #p(express_end_date),
    express_remark = #p(express_remark),
    system_update_user_id = #p(system_update_user_id),
    system_update_time = #p(system_update_time),
    system_version = system_version + 1
    WHERE system_status = 1
    AND express_id = #p(express_id)
    AND system_version = #p(system_version)
  #end

  #sql("deleteByExpress_idAndSystem_version")
    UPDATE table_express SET
    system_update_user_id = #p(system_update_user_id),
    system_update_time = #p(system_update_time),
    system_version = system_version + 1,
    system_status = 0
    WHERE system_status = 1
    AND express_id = #p(express_id)
    AND system_version = #p(system_version)
  #end

#end