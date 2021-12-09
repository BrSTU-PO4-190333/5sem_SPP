using System;

public class GPI_CardData
{
	private long gpi_card_number;
	private double gpi_sum;

	public GPI_CardData(long gpi_card_number, double gpi_sum)
	{
		this.gpi_card_number = gpi_card_number;
		this.gpi_sum = gpi_sum;
	}

	public long GPI_get_gpi_card_number()
	{
		return gpi_card_number;
	}

	public double GPI_get_gpi_sum()
    {
		return gpi_sum;
    }

	public void GPI_add_sum_5()
    {
		gpi_sum += 5;
	}

	public void GPI_add_sum_10()
	{
		gpi_sum += 10;
	}

	public void GPI_add_sum_20()
	{
		gpi_sum += 20;
	}

	public void GPI_add_sum_50()
	{
		gpi_sum += 50;
	}

	public bool GPI_withdraw_sum_5()
    {
		if (gpi_sum >= 5)
        {
			gpi_sum -= 5;
			return true;
		}

		return false;
    }

	public bool GPI_withdraw_sum_10()
	{
		if (gpi_sum >= 10)
		{
			gpi_sum -= 10;
			return true;
		}

		return false;
	}

	public bool GPI_withdraw_sum_20()
	{
		if (gpi_sum >= 20)
		{
			gpi_sum -= 20;
			return true;
		}

		return false;
	}

	public bool GPI_withdraw_sum_50()
	{
		if (gpi_sum >= 50)
		{
			gpi_sum -= 50;
			return true;
		}

		return false;
	}
}
