using System;
using System.Collections.Generic;

partial class gpi_LibraryReader
{
	public List<gpi_Reader> gpi_readers = new List<gpi_Reader>();

	public class gpi_Reader
	{
		public String gpi_readerName;
		public Boolean gpi_blackBook;

		public gpi_Reader(string gpi_readerName)
		{
			this.gpi_readerName = gpi_readerName;
			this.gpi_blackBook = false;
		}
	}

	public void gpi_addReader()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_addReader=");

		Console.Write(" gpi_readerName ");
		string gpi_readerName = Console.ReadLine();
		this.gpi_readers.Add(new gpi_Reader(gpi_readerName));

		Console.WriteLine(" Добавлен новый читатель");
		gpi_pressAnyKey();
	}

	public void gpi_printReaderTable()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_printReaderTable=");

		int gpi_length = this.gpi_readers.Count;
		if (gpi_length == 0)
        {
			Console.WriteLine(" Нет данных");
			gpi_pressAnyKey();
			return;
        }

		int gpi_i = 0;
		Console.WriteLine(" | {0,-8:s} | {1, -14:s} | {2,-48:s} |",
			"#",
			"В черной книге",
			"Имя читателя"
			);
		Console.WriteLine(" | {0,-8:s} | {1, -14:s} | {2,-48:s} |",
			"--------",
			"--------------",
			"------------------------------------------------"
			);
		while (gpi_i < gpi_length)
		{
			Console.WriteLine(" | {0,-8:d} | {1, -14:s} | {2,-48:s} |",
				gpi_i,
				this.gpi_readers[gpi_i].gpi_blackBook,
				this.gpi_readers[gpi_i].gpi_readerName
				);
			++gpi_i;
		}

		gpi_pressAnyKey();
	}

	public void gpi_deleteReader()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_deleteReader=");

		int gpi_length = this.gpi_readers.Count;
		if (gpi_length == 0)
		{
			Console.WriteLine(" Нет элементов для удаления");
			gpi_pressAnyKey();
			return;
		}

		try
		{
			Console.Write(" gpi_id ");
			int gpi_id = Convert.ToInt32(Console.ReadLine());
			this.gpi_readers.RemoveAt(gpi_id);
			Console.WriteLine(" Читатель удалён успешно");
			gpi_pressAnyKey();
		}
		catch (System.FormatException)
		{
			gpi_deleteReader();
			return;
		}
		catch (System.ArgumentOutOfRangeException)
		{
			Console.WriteLine(" Нет такого элемента под таким gpi_id");
			gpi_pressAnyKey();
		}
	}

	public void gpi_editReaderName()
	{
		Console.Clear();
		print_author("Галанин П. И.", "=gpi_editReaderName=");

		int gpi_length = this.gpi_readers.Count;
		if (gpi_length == 0)
		{
			Console.WriteLine(" Нет элементов для изменения");
			gpi_pressAnyKey();
			return;
		}

		try
		{
			Console.Write(" gpi_id ");
			int gpi_id = Convert.ToInt32(Console.ReadLine());
			while (gpi_id < 0 || gpi_id >= gpi_length)
			{
				Console.Write(" gpi_id ");
				gpi_id = Convert.ToInt32(Console.ReadLine());
			}

			Console.Write(" gpi_readerName ");
			string gpi_readerName = Console.ReadLine();
			this.gpi_readers[gpi_id].gpi_readerName = gpi_readerName;

			Console.WriteLine(" Имя читателя изменено успешно");
			gpi_pressAnyKey();
		}
		catch (System.FormatException)
		{
			gpi_editReaderName();
		}
		catch (System.ArgumentOutOfRangeException)
		{
			Console.WriteLine(" Нет такого элемента под таким gpi_id");
			gpi_pressAnyKey();
		}
	}
}
