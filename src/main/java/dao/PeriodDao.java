package dao;

import java.util.Collection;
import java.util.List;

import mapping.Period;

public interface PeriodDao<Period, Integer> {

	public mapping.Period getPeriod(Integer idPeriod);
}
