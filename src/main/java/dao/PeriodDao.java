package dao;

import java.util.Collection;
import java.util.List;

import mapping.Period;

public interface PeriodDao<Period, Integer> {

	public Collection<Period> getPeriod();
}
