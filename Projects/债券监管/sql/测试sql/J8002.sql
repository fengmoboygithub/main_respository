/*J8002测试sql*/
select 
    a.id, a.abs_name, a.abs_type, a.abs_code, a.abs_short_name, a.trem, a.trem_remark, a.bond_rating, a.
    credit_measures, a.trading_location, a.current_bond_rating, a.issue_rate, a.issue_time, a.interest_time, a.
    debt_account, a.individual_investor_account, a.personal_debt_rate, a.current_rate, a.due_time, a.
    proper_management, a.proper_management_time, a.original_owner_name, a.original_owner_srb, a.
    registered_place, a.registration_place, a.industry, a.business_scope, a.nature, a.main_business, a.
    if_belongs_financial, a.main_rating, a.relate_srb, a.manager_name, a.manager_disclosure_specialist, a.
    specialist_contact_way, a.manager_charger, a.manager_contact_way, a.manager_registered_place, a.
    manager_srb, a.accounting_name, a.accounting_signature, a.law_name, a.law_signature, a.rating_agency_name, a.
    rating_agency_contact_way, a.rating_agency_charge, a.asset_appraisal_agency, a.asset_appraisal_agency_charge, a.
    security_rate, a.JUR_SRB, a.edit_state, a.no_action_letter_time, a.serial_number, a.child_code, a.
    Custodian, a1.listing_time, a1.state, a.other_rating_agency_name
    from abs_base_info a right join abs_issue_info a1 on a1.base_id=a.id where state =1 and abs_code != '' and abs_code is not null
/*J8002测试重复sql*/
select abs_code, COUNT(abs_code)
from abs_base_info a right join abs_issue_info a1 on a1.base_id=a.id where state =1 and abs_code != '' and abs_code is not null GROUP BY abs_code HAVING COUNT(abs_code) > 1
