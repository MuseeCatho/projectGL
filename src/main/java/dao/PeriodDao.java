package dao;

import java.util.Collection;
import java.util.List;

import mapping.Period;

public interface PeriodDao<Period, Integer> {

	public Period getPeriodId(Integer idPeriod);
	public Collection<Period> getPeriod();
	
	public void insertPeriod(Period entity);
	public void deletePeriod(Period entity);
}
