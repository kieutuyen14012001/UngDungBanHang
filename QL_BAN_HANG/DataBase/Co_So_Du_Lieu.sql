USE [QL_BAN_HANG]
GO
/****** Object:  Database [QL_BAN_HANG]    Script Date: 05/31/2015 02:47:10 ******/
CREATE DATABASE [QL_BAN_HANG] ON  PRIMARY 
( NAME = N'QL_BAN_HANG', FILENAME = N'D:\QL_BAN_HANG\DataBaseQL_BAN_HANG.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QL_BAN_HANG_log', FILENAME = N'D:\QL_BAN_HANG\DataBase\QL_BAN_HANG_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QL_BAN_HANG] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QL_BAN_HANG].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QL_BAN_HANG] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET ANSI_NULLS OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET ANSI_PADDING OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET ARITHABORT OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [QL_BAN_HANG] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [QL_BAN_HANG] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [QL_BAN_HANG] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET  DISABLE_BROKER
GO
ALTER DATABASE [QL_BAN_HANG] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [QL_BAN_HANG] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [QL_BAN_HANG] SET  READ_WRITE
GO
ALTER DATABASE [QL_BAN_HANG] SET RECOVERY SIMPLE
GO
ALTER DATABASE [QL_BAN_HANG] SET  MULTI_USER
GO
ALTER DATABASE [QL_BAN_HANG] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [QL_BAN_HANG] SET DB_CHAINING OFF
GO
USE [QL_BAN_HANG]
GO
/****** Object:  Table [dbo].[SAN_PHAM]    Script Date: 05/31/2015 02:47:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SAN_PHAM](
	[MA_SAN_PHAM] [varchar](30) NOT NULL,
	[TEN_SAN_PHAM] [nvarchar](200) NULL,
	[LOAI_SAN_PHAM] [nvarchar](100) NULL,
	[SO_LUONG] [numeric](18, 0) NULL,
	[DON_GIA] [numeric](18, 0) NULL,
 CONSTRAINT [PK_SAN_PHAM] PRIMARY KEY CLUSTERED 
(
	[MA_SAN_PHAM] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[SAN_PHAM] ([MA_SAN_PHAM], [TEN_SAN_PHAM], [LOAI_SAN_PHAM], [SO_LUONG], [DON_GIA]) VALUES (N'SP001', N'Ô mô 0,5kg', N'Xà phòng', CAST(997 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)))
INSERT [dbo].[SAN_PHAM] ([MA_SAN_PHAM], [TEN_SAN_PHAM], [LOAI_SAN_PHAM], [SO_LUONG], [DON_GIA]) VALUES (N'SP002', N'Clear 200ml', N'Dầu gội đầu', CAST(98 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)))
/****** Object:  Table [dbo].[NHAN_VIEN]    Script Date: 05/31/2015 02:47:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NHAN_VIEN](
	[MA_NHAN_VIEN] [varchar](30) NOT NULL,
	[TEN_NHAN_VIEN] [nvarchar](100) NULL,
	[DIEN_THOAI] [varchar](15) NULL,
	[TEN_DANG_NHAP] [varchar](50) NULL,
	[MAT_KHAU] [varchar](50) NULL,
 CONSTRAINT [PK_NHAN_VIEN] PRIMARY KEY CLUSTERED 
(
	[MA_NHAN_VIEN] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[NHAN_VIEN] ([MA_NHAN_VIEN], [TEN_NHAN_VIEN], [DIEN_THOAI], [TEN_DANG_NHAP], [MAT_KHAU]) VALUES (N'NV001', N'Nguyễn Văn Anh', N'01234567899', N'anhnv', N'123456')
/****** Object:  StoredProcedure [dbo].[gen_UpdateData_java]    Script Date: 05/31/2015 02:47:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   procedure [dbo].[gen_UpdateData_java]
( @ip_table_name nvarchar(200) )
as
begin


	declare  cur_columns cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 
	
	declare  cur_columns1 cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 
		  
	declare  cur_columns2 cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 

	declare @v_table_name nvarchar(50)
	declare @v_column_name nvarchar(100)
	declare @v_is_nullable nvarchar(50)
	declare @v_data_type nvarchar(50)
	declare @sql_update nvarchar(500)
	declare @dk nvarchar(100)
	declare @dem int
	SET @dem=0
	SET @sql_update = '	sql = "UPDATE '
	SET @dk = ''


	open cur_columns
	fetch next from cur_columns 
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	print ' private void UpdateData_' + @ip_table_name + '() {'
	print '	String sql = null;' 
	print '	DBConnect conn = new DBConnect();' 
	SET @sql_update = @sql_update + @ip_table_name +' SET '
	while @@fetch_status = 0
	begin
		print '	String var_'+@v_column_name+'=txt_'+@v_column_name+'.getText();'
		fetch next from cur_columns 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	close cur_columns
	deallocate cur_columns
	
	open cur_columns1
	fetch next from cur_columns1
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	while @@fetch_status = 0
	begin
		IF(@v_data_type = 'decimal' OR @v_data_type = 'int' OR @v_data_type = 'numeric')
			BEGIN
				IF(@dk = '')
					BEGIN
						SET @dk = @v_column_name+'='''+'"+var_'+@v_column_name+'+"'
					END
				SET @sql_update = @sql_update +@v_column_name+'='''+'"+var_'+@v_column_name+'+",'
			END
		ELSE
			BEGIN
				IF(@dk = '')
					BEGIN
						SET @dk = @v_column_name+'=N'''+'"+var_'+@v_column_name+'+"'
					END
				SET @sql_update = @sql_update +@v_column_name+'=N'''+'"+var_'+@v_column_name+'+"'','
			END
		fetch next from cur_columns1 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	SET @sql_update = SUBSTRING(@sql_update, 0,LEN(@sql_update))
	SET @sql_update = @sql_update+' WHERE '+@dk+'''";'
		print @sql_update
	print ''
	print '	try {' 
	print '			conn.ExecuteQuery(sql);'
	print '			JOptionPane.showMessageDialog(this, "Cap nhat thanh cong!");'
	print '			ResetControl();'
	print '			conn.closeConnection();'
	print '	} catch (Exception e) {'
	print '		e.printStackTrace();'
	print '	}'
	print '}'
	close cur_columns1
	deallocate cur_columns1
	
	open cur_columns2
	fetch next from cur_columns2
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	print 'private void LoadDataFromTable2Control(){'
	print '	DefaultTableModel model = (DefaultTableModel) tbl_'+@v_table_name+'.getModel();'
	while @@fetch_status = 0
	begin
		print '	txt_'+@v_column_name+'.setText(model.getValueAt(tbl_'+@v_table_name+'.getSelectedRow(), '+CONVERT(varchar(10), @dem)+').toString());'
		SET @dem = @dem +1
		fetch next from cur_columns2
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	print '}'
	close cur_columns2
	deallocate cur_columns2
END
GO
/****** Object:  StoredProcedure [dbo].[gen_show_data_2_table_java]    Script Date: 05/31/2015 02:47:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   procedure [dbo].[gen_show_data_2_table_java]
( @ip_table_name nvarchar(200) )
as
begin


	declare  cur_columns cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 
		  
	declare  cur_columns2 cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 
	declare  cur_columns1 cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 

	declare @v_table_name nvarchar(50)
	declare @v_column_name nvarchar(100)
	declare @v_is_nullable nvarchar(50)
	declare @v_data_type nvarchar(50)
	declare @count int
	declare @dem int
	SET @count=0
	SET @dem=0


	open cur_columns
	fetch next from cur_columns 
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	print '/**
*@author ZENT BK
* http://zentgroup.net/
* https://www.facebook.com/vuvan.thuong.5496
*/' 
	print 'private DefaultTableModel dtm_'+ @ip_table_name +' = new DefaultTableModel();' 
	print 'private void loadData_' + @ip_table_name + '() {' 
	print '	dtm_'+ @ip_table_name +' = new DefaultTableModel();' 
	print '	try {' 
	print '		String sql = "select * from '+@ip_table_name+'";' 
	print '		DBConnect conn = new DBConnect();' 
	print '		ResultSet rs = conn.Query_Db(sql);' 
	print '		//Create colum for table' 
	while @@fetch_status = 0
	begin
		SET @count = @count+1
		print '		dtm_'+ @ip_table_name +'.addColumn("'+@v_column_name+'");'
		fetch next from cur_columns 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
		
	end
	close cur_columns
	deallocate cur_columns
	
	open cur_columns1
	fetch next from cur_columns1
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	print '		while (rs.next()) {'
	while @@fetch_status = 0
	begin
		print '			String str_'+@v_column_name+'=rs.getString('+CONVERT(varchar(10), @dem+1)+');' 
		SET @dem = @dem +1;
		fetch next from cur_columns1 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	print '			Vector row = new Vector();'
	close cur_columns1
	deallocate cur_columns1
	
	open cur_columns2
	fetch next from cur_columns2
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	while @@fetch_status = 0
	begin
		print '			row.addElement(str_'+@v_column_name+');' 
		fetch next from cur_columns2 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	print '			dtm_'+ @ip_table_name +'.addRow(row);'
	print '		}tbl_'+ @ip_table_name+'.setModel(dtm_'+ @ip_table_name +');'
	print '		conn.closeConnection();'
	print '	} catch (Exception e) {'
	print '		e.printStackTrace();'
	print '	}'
	print '}'
	close cur_columns2
	deallocate cur_columns2
end
GO
/****** Object:  StoredProcedure [dbo].[gen_InsertData_java]    Script Date: 05/31/2015 02:47:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   procedure [dbo].[gen_InsertData_java]
( @ip_table_name nvarchar(200) )
as
begin


	declare  cur_columns cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 
	
	declare  cur_columns1 cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 
		  
	declare  cur_columns2 cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 

	declare @v_table_name nvarchar(50)
	declare @v_column_name nvarchar(100)
	declare @v_is_nullable nvarchar(50)
	declare @v_data_type nvarchar(50)
	declare @sql_insert nvarchar(500)
	declare @count int
	declare @dem int
	SET @count=0
	SET @dem=0
	SET @sql_insert = '	sql = "INSERT INTO '


	open cur_columns
	fetch next from cur_columns 
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
  
	print ' private void InsertData_' + @ip_table_name + '() {'
	print '	String sql = null;' 
	print '	DBConnect conn = new DBConnect();' 
	SET @sql_insert = @sql_insert + @ip_table_name +'('
	while @@fetch_status = 0
	begin
		print '	String var_'+@v_column_name+'=txt_'+@v_column_name+'.getText();'
		SET @sql_insert = @sql_insert + +@v_column_name+','
		fetch next from cur_columns 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	SET @sql_insert = SUBSTRING(@sql_insert, 0,LEN(@sql_insert))
	SET @sql_insert = @sql_insert+') VALUES ('
	close cur_columns
	deallocate cur_columns
	
	open cur_columns1
	fetch next from cur_columns1
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	while @@fetch_status = 0
	begin
		IF(@v_data_type = 'decimal' OR @v_data_type = 'int' OR @v_data_type = 'numeric')
			BEGIN
				SET @sql_insert = @sql_insert +'"+var_'+@v_column_name+'+",'
			END
		ELSE
			BEGIN
				SET @sql_insert = @sql_insert +'N'''+'"+var_'+@v_column_name+'+"'','
			END
		fetch next from cur_columns1 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	SET @sql_insert = SUBSTRING(@sql_insert, 0,LEN(@sql_insert))
	SET @sql_insert = @sql_insert+')";'
		print @sql_insert
	print ''
	print '	try {' 
	print '			conn.ExecuteQuery(sql);'
	print '			JOptionPane.showMessageDialog(this, "Them thanh cong!");'
	print '			ResetControl();'
	print '			conn.closeConnection();'
	print '	} catch (Exception e) {'
	print '		e.printStackTrace();'
	print '	}'
	print '}'
	close cur_columns1
	deallocate cur_columns1
	
	open cur_columns2
	fetch next from cur_columns2
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	print ' private void ResetControl(){'
	while @@fetch_status = 0
	begin
		print '	txt_'+@v_column_name+'.setText("");'
		fetch next from cur_columns2
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	print '}'
	close cur_columns2
	deallocate cur_columns2
END
GO
/****** Object:  StoredProcedure [dbo].[gen_DeleteData_java]    Script Date: 05/31/2015 02:47:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE   procedure [dbo].[gen_DeleteData_java]
( @ip_table_name nvarchar(200) )
as
begin


	declare  cur_columns cursor 
	for
		select  table_name, 
				column_name, 
	       		is_nullable,
		   		data_type
	from information_schema.columns
	where table_name = @ip_table_name and
		  TABLE_SCHEMA = 'dbo' 


	declare @v_table_name nvarchar(50)
	declare @v_column_name nvarchar(100)
	declare @v_is_nullable nvarchar(50)
	declare @v_data_type nvarchar(50)
	declare @sql_delete nvarchar(500)
	declare @dk nvarchar(100)
	declare @var int
	SET @sql_delete = '	sql = "DELETE FROM  '
	SET @dk = ''
	SET @var =0
	
	open cur_columns
	fetch next from cur_columns 
	into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	print ' private void DeleteData_' + @ip_table_name + '() {'
	print '	String sql = null;' 
	print '	DBConnect conn = new DBConnect();' 
	SET @sql_delete = @sql_delete + @ip_table_name
	while @@fetch_status = 0
	begin
		IF(@var = 0)
		BEGIN
			print '	String var_'+@v_column_name+'=txt_'+@v_column_name+'.getText();'
			SET @var = 1
		END
		IF(@v_data_type = 'decimal' OR @v_data_type = 'int' OR @v_data_type = 'numeric')
			BEGIN
				IF(@dk = '')
					BEGIN
						SET @dk = @v_column_name+'='''+'"+var_'+@v_column_name+'+"'
					END
			END
		ELSE
			BEGIN
				IF(@dk = '')
					BEGIN
						SET @dk = @v_column_name+'=N'''+'"+var_'+@v_column_name+'+"'
					END
			END
		fetch next from cur_columns 
		into @v_table_name, @v_column_name, @v_is_nullable, @v_data_type
	end
	SET @sql_delete = @sql_delete+' WHERE '+@dk+'''";'
	print @sql_delete
	print ''
	print '	try {' 
	print '			conn.ExecuteQuery(sql);'
	print '			JOptionPane.showMessageDialog(this, "Xoa thanh cong!");'
	print '			ResetControl();'
	print '			conn.closeConnection();'
	print '	} catch (Exception e) {'
	print '		e.printStackTrace();'
	print '	}'
	print '}'
	close cur_columns
	deallocate cur_columns
END
GO
/****** Object:  Table [dbo].[BAN_HANG]    Script Date: 05/31/2015 02:47:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BAN_HANG](
	[MA_HOA_DON] [varchar](30) NOT NULL,
	[MA_NHAN_VIEN] [varchar](30) NULL,
	[MA_SAN_PHAM] [varchar](30) NOT NULL,
	[SO_LUONG] [numeric](18, 0) NULL,
	[GIA_BAN] [numeric](18, 0) NULL,
	[THANH_TIEN] [numeric](18, 0) NULL,
	[NGAY_BAN_HANG] [varchar](15) NULL,
 CONSTRAINT [PK_BAN_HANG_1] PRIMARY KEY CLUSTERED 
(
	[MA_HOA_DON] ASC,
	[MA_SAN_PHAM] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[BAN_HANG] ([MA_HOA_DON], [MA_NHAN_VIEN], [MA_SAN_PHAM], [SO_LUONG], [GIA_BAN], [THANH_TIEN], [NGAY_BAN_HANG]) VALUES (N'201505310126', N'NV001', N'SP001', CAST(1 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), N'2015/05/31')
INSERT [dbo].[BAN_HANG] ([MA_HOA_DON], [MA_NHAN_VIEN], [MA_SAN_PHAM], [SO_LUONG], [GIA_BAN], [THANH_TIEN], [NGAY_BAN_HANG]) VALUES (N'201505310126', N'NV001', N'SP002', CAST(1 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), N'2015/05/31')
INSERT [dbo].[BAN_HANG] ([MA_HOA_DON], [MA_NHAN_VIEN], [MA_SAN_PHAM], [SO_LUONG], [GIA_BAN], [THANH_TIEN], [NGAY_BAN_HANG]) VALUES (N'201505310235', N'NV001', N'SP001', CAST(1 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), N'2015/05/31')
INSERT [dbo].[BAN_HANG] ([MA_HOA_DON], [MA_NHAN_VIEN], [MA_SAN_PHAM], [SO_LUONG], [GIA_BAN], [THANH_TIEN], [NGAY_BAN_HANG]) VALUES (N'201505310236', N'NV001', N'SP001', CAST(1 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), N'2015/05/31')
INSERT [dbo].[BAN_HANG] ([MA_HOA_DON], [MA_NHAN_VIEN], [MA_SAN_PHAM], [SO_LUONG], [GIA_BAN], [THANH_TIEN], [NGAY_BAN_HANG]) VALUES (N'201505310236', N'NV001', N'SP002', CAST(1 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), CAST(30000 AS Numeric(18, 0)), N'2015/05/31')
/****** Object:  ForeignKey [FK_BAN_HANG_NHAN_VIEN]    Script Date: 05/31/2015 02:47:13 ******/
ALTER TABLE [dbo].[BAN_HANG]  WITH CHECK ADD  CONSTRAINT [FK_BAN_HANG_NHAN_VIEN] FOREIGN KEY([MA_NHAN_VIEN])
REFERENCES [dbo].[NHAN_VIEN] ([MA_NHAN_VIEN])
GO
ALTER TABLE [dbo].[BAN_HANG] CHECK CONSTRAINT [FK_BAN_HANG_NHAN_VIEN]
GO
/****** Object:  ForeignKey [FK_BAN_HANG_SAN_PHAM]    Script Date: 05/31/2015 02:47:13 ******/
ALTER TABLE [dbo].[BAN_HANG]  WITH CHECK ADD  CONSTRAINT [FK_BAN_HANG_SAN_PHAM] FOREIGN KEY([MA_SAN_PHAM])
REFERENCES [dbo].[SAN_PHAM] ([MA_SAN_PHAM])
GO
ALTER TABLE [dbo].[BAN_HANG] CHECK CONSTRAINT [FK_BAN_HANG_SAN_PHAM]
GO
