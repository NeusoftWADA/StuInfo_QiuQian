USE [master]
GO
/****** Object:  Database [StuInfo]    Script Date: 2020/11/26 20:22:53 ******/
CREATE DATABASE [StuInfo]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'StuInfo', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\StuInfo.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'StuInfo_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\StuInfo_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [StuInfo] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StuInfo].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StuInfo] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [StuInfo] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [StuInfo] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [StuInfo] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [StuInfo] SET ARITHABORT OFF 
GO
ALTER DATABASE [StuInfo] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [StuInfo] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [StuInfo] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [StuInfo] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [StuInfo] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [StuInfo] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [StuInfo] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [StuInfo] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [StuInfo] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [StuInfo] SET  ENABLE_BROKER 
GO
ALTER DATABASE [StuInfo] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [StuInfo] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [StuInfo] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [StuInfo] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [StuInfo] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [StuInfo] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [StuInfo] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [StuInfo] SET RECOVERY FULL 
GO
ALTER DATABASE [StuInfo] SET  MULTI_USER 
GO
ALTER DATABASE [StuInfo] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [StuInfo] SET DB_CHAINING OFF 
GO
ALTER DATABASE [StuInfo] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [StuInfo] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [StuInfo] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'StuInfo', N'ON'
GO
ALTER DATABASE [StuInfo] SET QUERY_STORE = OFF
GO
USE [StuInfo]
GO
/****** Object:  Table [dbo].[StuInfo]    Script Date: 2020/11/26 20:22:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StuInfo](
	[ID] [varchar](20) NOT NULL,
	[Name] [varchar](20) NOT NULL,
	[Gender] [char](2) NULL,
	[Birthday] [datetime] NOT NULL,
	[State] [char](4) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[StuInfo]  WITH CHECK ADD CHECK  (([Gender]='男' OR [gender]='女'))
GO
ALTER TABLE [dbo].[StuInfo]  WITH CHECK ADD CHECK  (([State]='在读' OR [State]='休学'))
GO
USE [master]
GO
ALTER DATABASE [StuInfo] SET  READ_WRITE 
GO
