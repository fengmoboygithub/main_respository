/*J8005测试sql*/
select
    a.id, a.bond_code, a.bond_type, a.bond_main_type, a.update_time, a.trust_compensation, a.risk_state, 
	a.breach_time, a.breach_bature, a.breach_cause, a.paid_amount, a.unpaid_amount, a.all_paid_time, a.state
    from 
	(select
		rbc.id, 
		bi.bond_code, 
		bi.bond_type, 
		'01' as bond_main_type, 
		rbc.update_time, 
		rbi.trust_compensation, 
		rbi.risk_state, 
		rbc.breach_time, 
		rbc.breach_bature, 
		rbc.breach_cause, 
		rbc.paid_amount, 
		rbc.unpaid_amount, 
		rbc.all_paid_time, 
		rbc.state
		from risk_breach_cause rbc
			join bond_risk_breach_info rbi on rbc.info_id=rbi.id
			join bond_base_info bi on rbi.base_id=bi.id and bi.state=1 and bi.edit_state=1
	union all
	select 
		rbc.id, 
		bi.abs_code, 
		'0201' as bond_type, 
		'02' as bond_main_type, 
		rbc.update_time, 
		'' as trust_compensation, 
		rbi.risk_state, 
		rbc.breach_time, 
		rbc.breach_bature, 
		rbc.breach_cause, 
		rbc.paid_amount, 
		rbc.unpaid_amount, 
		rbc.all_paid_time,
		'1' as state
		from abs_risk_breach_cause rbc
			join abs_risk_breach_info rbi on rbc.info_id=rbi.id
			join abs_base_info bi on rbi.base_id=bi.id
			right join abs_issue_info a1 on a1.base_id=bi.id where a1.state=1) a
where a.bond_code is not null and a.bond_code != ''
/*J8005测试重复sql*/
select
    a.bond_code,COUNT(a.bond_code)
    from 
	(select
		rbc.id, 
		bi.bond_code, 
		bi.bond_type, 
		'01' as bond_main_type, 
		rbc.update_time, 
		rbi.trust_compensation, 
		rbi.risk_state, 
		rbc.breach_time, 
		rbc.breach_bature, 
		rbc.breach_cause, 
		rbc.paid_amount, 
		rbc.unpaid_amount, 
		rbc.all_paid_time, 
		rbc.state
		from risk_breach_cause rbc
			join bond_risk_breach_info rbi on rbc.info_id=rbi.id
			join bond_base_info bi on rbi.base_id=bi.id and bi.state=1 and bi.edit_state=1
	union all
	select 
		rbc.id, 
		bi.abs_code, 
		'0201' as bond_type, 
		'02' as bond_main_type, 
		rbc.update_time, 
		'' as trust_compensation, 
		rbi.risk_state, 
		rbc.breach_time, 
		rbc.breach_bature, 
		rbc.breach_cause, 
		rbc.paid_amount, 
		rbc.unpaid_amount, 
		rbc.all_paid_time,
		'1' as state
		from abs_risk_breach_cause rbc
			join abs_risk_breach_info rbi on rbc.info_id=rbi.id
			join abs_base_info bi on rbi.base_id=bi.id
			right join abs_issue_info a1 on a1.base_id=bi.id where a1.state=1) a 
where bond_code is not null and bond_code != ''
GROUP BY a.bond_code HAVING COUNT(a.bond_code) > 1
