/*J8004测试sql*/
select
    a.bond_code, a.bond_type, a.bond_main_type, 
	a.agency_type1, a.org_name1, a.project_leader1, 
	a.agency_type2, a.org_name2, a.project_leader2, 
	a.agency_type3, a.org_name3, a.project_leader3, 
	a.agency_type4, a.org_name4, a.project_leader4, 
	a.agency_type5, a.org_name5, a.project_leader5, 
	a.edit_state
    from (select
		bond_code, 
		bond_type, 
		'01' as bond_main_type, 
		'01' as agency_type1, 
		underwriter_name as org_name1,
		underwriter_charge as project_leader1,
		'02' as agency_type2, 
		accounting_name as org_name2,
		accounting_signatory as project_leader2,
		'03' as agency_type3,
		law_name as org_name3,
		law_signatory as project_leader3,
		'04' as agency_type4, 
		trustee_name as org_name4,
		trustee_charge as project_leader4,
		'05' as agency_type5, 
		rating_agency_name as org_name5,
		rating_agency_charge as project_leader5,
		edit_state
		from bond_base_info where state=1 and edit_state=1 and bond_code is not null and bond_code != ''
	union all
	select
		b1.abs_code as bond_code, 
		'0201' as bond_type, 
		'02' as bond_main_type, 
		'02' as agency_type1, 
		b1.accounting_name as org_name1,
		b1.accounting_signature as project_leader1,
		'03' as agency_type2, 
		b1.law_name as org_name2,
		b1.law_signature as project_leader2,
		'05' as agency_type3,
		b1.rating_agency_name as org_name3,
		b1.rating_agency_charge as project_leader3,
		'07' as agency_type4, 
		b1.asset_appraisal_agency as org_name4,
		b1.asset_appraisal_agency_charge as project_leader4,
		'' as agency_type5, 
		'' as org_name5,
		'' as project_leader5,  
		b1.edit_state
		from abs_base_info b1 right join abs_issue_info a1 on a1.base_id=b1.id where a1.state=1 and b1.abs_code != '' and b1.abs_code is not null) a

/*J8004测试重复sql*/
select
    a.bond_code,COUNT(a.bond_code)
    from (select
		bond_code, 
		bond_type, 
		'01' as bond_main_type, 
		'01' as agency_type1, 
		underwriter_name as org_name1,
		underwriter_charge as project_leader1,
		'02' as agency_type2, 
		accounting_name as org_name2,
		accounting_signatory as project_leader2,
		'03' as agency_type3,
		law_name as org_name3,
		law_signatory as project_leader3,
		'04' as agency_type4, 
		trustee_name as org_name4,
		trustee_charge as project_leader4,
		'05' as agency_type5, 
		rating_agency_name as org_name5,
		rating_agency_charge as project_leader5,
		edit_state
		from bond_base_info where state=1 and edit_state=1 and bond_code is not null and bond_code != ''
	union all
	select
		b1.abs_code as bond_code, 
		'0201' as bond_type, 
		'02' as bond_main_type, 
		'02' as agency_type1, 
		b1.accounting_name as org_name1,
		b1.accounting_signature as project_leader1,
		'03' as agency_type2, 
		b1.law_name as org_name2,
		b1.law_signature as project_leader2,
		'05' as agency_type3,
		b1.rating_agency_name as org_name3,
		b1.rating_agency_charge as project_leader3,
		'07' as agency_type4, 
		b1.asset_appraisal_agency as org_name4,
		b1.asset_appraisal_agency_charge as project_leader4,
		'' as agency_type5, 
		'' as org_name5,
		'' as project_leader5,  
		b1.edit_state
		from abs_base_info b1 right join abs_issue_info a1 on a1.base_id=b1.id where a1.state=1 and b1.abs_code != '' and b1.abs_code is not null) a
GROUP BY a.bond_code HAVING COUNT(a.bond_code) > 1