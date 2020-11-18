/*J8001测试sql*/
select
    ID, bond_code, bond_name, short_name, bond_type, trading_location, rating, initial_rating, 
    current_rating, stock_code, credit_measures, issue_way, be_issue_amount, real_issue_amount, 
    trusteeship, trem, trem_remark, issue_rate, issue_time, list_time, approval_time, 
    interest_time, due_time, resale_time, relate_srb, debt_account, individual_investor_account, 
    personal_debt_rate, current_rate, proper_management, proper_management_time, issuer_name, 
    other_issuer_name, issuer_industry, issuer_province, issuer_city, issuer_srb, issuer_business, 
    issuer_nature, issuer_financial, issuer_rating, com_initial_rating, com_current_rating, 
    issuer_contact_way, underwriter_name, underwriter_charge, underwriter_srb, accounting_name, 
    accounting_signatory, law_name, law_signatory, rating_agency_name, other_rating_agency_name, 
    rating_agency_charge, rating_agency_srb, trustee_name, trustee_charge, trustee_charge_contact_way, 
    trustee_srb, issuer_id, underwriter_id, law_firm_id, accounting_firm_id, guarantor_id, 
    credit_rating_agency_id, trustee_id, intermediary_agency_id, publisher_id, state, 
    create_time, update_time, remark, user_id, jur_srb, audit_state, edit_state, serial_number
    from bond_base_info where state=1 and edit_state=1 and bond_code is not null and bond_code != ''
/*J8001测试重复sql*/
select bond_code,COUNT(bond_code)
from bond_base_info where state=1 and edit_state=1 and bond_code is not null and bond_code != '' GROUP BY bond_code HAVING COUNT(bond_code)>1

