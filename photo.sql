create database photo
go
USE [photo]
GO
/****** Object:  Table [dbo].[contact]    Script Date: 9/20/2020 15:51:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Share](
	[icon] [nvarchar](50) NULL,
	[socialNetwork] [nvarchar](50) NULL,
	[URL] [nvarchar](50) NULL
) ON [PRIMARY]
INSERT [dbo].[Share] ([icon], [socialNetwork], [URL]) VALUES (N'fb.png', N'Facebook', N'https://www.facebook.com/')
INSERT [dbo].[Share] ([icon], [socialNetwork], [URL]) VALUES (N'tw.png', N'Twitter', N'https://twitter.com/')
INSERT [dbo].[Share] ([icon], [socialNetwork], [URL]) VALUES (N'gg.png', N'Google+', N'https://www.google.com.vn/')

CREATE TABLE [dbo].[Contact](
	[telephone] [nvarchar](max) NULL,
	[email] [nvarchar](max) NULL,
	[about] [nvarchar](max) NULL,
	[address] [nvarchar](max) NULL,
	[city] [nvarchar](max) NULL,
	[country] [nvarchar](max) NULL,
	[image_main] [nvarchar](max) NULL,
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
INSERT [dbo].[contact] ([telephone], [email], [about], [address], [city], [country], [image_main]) VALUES (N'0123456789101', N'abc123@jhkj.com', N'About me
Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim', N'Thach Hoa, Thach That', N'Ha Noi', N'Viet Nam', N'homeImage.jpg')
GO
/****** Object:  Table [dbo].[galery]    Script Date: 24/03/2020 15:51:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[gallery](
	[ID] [int] NOT NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[name] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[image]    Script Date: 24/03/2020 15:51:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[image](
	[id] [int] NOT NULL,
	[gallery_id] [int] NULL,
	[image_url] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

INSERT [dbo].[gallery] ([ID], [title], [description], [name]) VALUES (1, N'View Gallery 1', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation1', N'Gallery 1')
INSERT [dbo].[gallery] ([ID], [title], [description], [name]) VALUES (2, N'View Gallery 2', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation2', N'Gallery 2')
INSERT [dbo].[gallery] ([ID], [title], [description], [name]) VALUES (3, N'View Gallery 3', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation3', N'Gallery 3')
INSERT [dbo].[gallery] ([ID], [title], [description], [name]) VALUES (4, N'View Gallery 4', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation4', N'Gallery 4')
INSERT [dbo].[gallery] ([ID], [title], [description], [name]) VALUES (5, N'View Gallery 5', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation5', N'Gallery 5')
INSERT [dbo].[gallery] ([ID], [title], [description], [name]) VALUES (6, N'View Gallery 6', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation6', N'Gallery 6')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (1, 1, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (2, 1, N'img2.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (3, 1, N'img3.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (4, 1, N'img4.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (5, 1, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (6, 1, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (7, 1, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (8, 1, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (9, 1, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (10, 1, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (11, 2, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (12, 2, N'img5.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (13, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (14, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (15, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (16, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (17, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (18, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (19, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (20, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (21, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (22, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (23, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (24, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (25, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (26, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (27, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (28, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (29, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (30, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (31, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (32, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (33, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (34, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (35, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (36, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (37, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (38, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (39, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (40, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (41, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (42, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (43, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (44, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (45, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (46, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (47, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (48, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (49, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (50, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (51, 1, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (52, 1, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (53, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (54, 2, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (55, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (56, 3, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (57, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (58, 4, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (59, 5, N'img1.jpg')
INSERT [dbo].[image] ([id], [gallery_id], [image_url]) VALUES (60, 5, N'img1.jpg')
