-- phpMyAdmin SQL Dump
-- version 4.6.6deb5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 2020-07-13 02:53:22
-- 服务器版本： 10.1.44-MariaDB-0ubuntu0.18.04.1
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wifilocate`
--

-- --------------------------------------------------------

--
-- 表的结构 `ap`
--

CREATE TABLE `ap` (
  `id` int(11) NOT NULL,
  `time` date DEFAULT NULL,
  `zone` int(11) NOT NULL,
  `locx` int(11) NOT NULL,
  `locy` int(11) NOT NULL,
  `bssid` varchar(20) NOT NULL,
  `ssid` varchar(20) NOT NULL,
  `strength` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `ap`
--

INSERT INTO `ap` (`id`, `time`, `zone`, `locx`, `locy`, `bssid`, `ssid`, `strength`) VALUES
(410, NULL, 1, 0, 0, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -53),
(411, NULL, 1, 0, 0, '88:cc:45:f2:75:34', 'tsy_202', -82),
(412, NULL, 1, 0, 0, '7c:52:59:3d:b0:94', 'zlz', -62),
(413, NULL, 1, 0, 0, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -37),
(414, NULL, 1, 0, 0, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -61),
(415, NULL, 1, 0, 0, '8a:cc:45:f0:75:34', 'tsy_public', -86),
(416, NULL, 1, 0, 1, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -44),
(417, NULL, 1, 0, 1, '7c:52:59:3d:b0:94', 'zlz', -67),
(418, NULL, 1, 0, 1, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -52),
(419, NULL, 1, 0, 1, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -71),
(420, NULL, 1, 0, 2, '7c:52:59:3d:b0:94', 'zlz', -68),
(421, NULL, 1, 0, 2, 'a8:e2:c3:c4:84:88', 'ChinaNet-RtrC', -89),
(422, NULL, 1, 0, 2, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -52),
(423, NULL, 1, 0, 2, 'f8:c3:9e:ad:1f:41', '', -88),
(424, NULL, 1, 0, 2, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -62),
(425, NULL, 1, 0, 3, 'b8:f8:83:34:be:75', 'xiaohongmao', -87),
(426, NULL, 1, 0, 3, '88:cc:45:f1:ea:90', 'tsy_F1EA90', -89),
(427, NULL, 1, 0, 3, '7c:52:59:3d:b0:94', 'zlz', -89),
(428, NULL, 1, 0, 3, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -67),
(429, NULL, 1, 0, 3, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -58),
(430, NULL, 1, 0, 3, '9c:9c:40:bc:08:31', 'ChinaNet-dq2b', -85),
(431, NULL, 1, 0, 3, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -91),
(432, NULL, 1, 0, 3, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -87),
(433, NULL, 1, 0, 4, 'bc:46:99:f8:1f:c0', 'TP-LINK_1FC0', -87),
(434, NULL, 1, 0, 4, 'c8:94:bb:21:05:7c', 'HUAWEI-R8MXUF', -92),
(435, NULL, 1, 0, 4, 'f8:c3:9e:ad:1f:40', 'HUAWEI-MMALD5', -86),
(436, NULL, 1, 0, 4, 'cc:2d:21:86:0c:25', 'ZYB', -87),
(437, NULL, 1, 0, 4, 'b8:f8:83:34:be:75', 'xiaohongmao', -71),
(438, NULL, 1, 0, 4, 'f0:10:ab:66:5c:10', 'CMCC-Eb6Q', -77),
(439, NULL, 1, 0, 4, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -69),
(440, NULL, 1, 0, 4, 'e4:f3:f5:a8:eb:26', 'MERCURY_EB26', -80),
(441, NULL, 1, 0, 4, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -78),
(442, NULL, 1, 0, 4, '2c:61:04:f6:48:ac', '360WiFi-F648AC', -85),
(443, NULL, 1, 0, 4, '7c:52:59:3d:b0:94', 'zlz', -78),
(444, NULL, 1, 0, 4, 'f8:48:fd:f4:bc:10', 'CMCC-Lj6Y', -83),
(445, NULL, 1, 0, 4, '74:ff:4c:78:9f:2c', 'tsy_201', -77),
(446, NULL, 1, 0, 4, '8a:cc:45:f0:ea:90', 'tsy_public', -76),
(447, NULL, 1, 0, 4, '88:cc:45:f1:ea:90', 'tsy_F1EA90', -76),
(448, NULL, 1, 0, 4, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -63),
(449, NULL, 1, 0, 4, 'd8:32:14:a4:0c:b0', 'liufangyu', -79),
(450, NULL, 1, 0, 4, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -69),
(451, NULL, 1, 0, 4, '34:5b:bb:10:84:bd', 'midea_ca_0189', -74),
(452, NULL, 1, 0, 4, 'b0:df:c1:93:d0:50', 'Tenda_AAAA', -68),
(453, NULL, 1, 0, 4, '9c:9c:40:bc:08:31', 'ChinaNet-dq2b', -72),
(454, NULL, 1, 0, 4, 'f8:c3:9e:ad:1f:3c', 'HUAWEI-MMALD5', -75),
(455, NULL, 1, 0, 4, 'bc:46:99:81:de:7c', 'TP-LINK_DE7C', -84),
(456, NULL, 1, 1, 0, '50:bd:5f:1a:3d:e5', 'TP-5510', -91),
(457, NULL, 1, 1, 0, '2c:61:04:f6:48:ac', '360WiFi-F648AC', -90),
(458, NULL, 1, 1, 0, '8a:cc:45:f0:75:34', 'tsy_public', -79),
(459, NULL, 1, 1, 0, '88:cc:45:f2:75:34', 'tsy_202', -83),
(460, NULL, 1, 1, 0, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -45),
(461, NULL, 1, 1, 0, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -39),
(462, NULL, 1, 1, 0, 'c0:61:18:53:0c:bf', 'LeXueJiaoYu', -88),
(463, NULL, 1, 1, 0, '7c:52:59:3d:b0:94', 'zlz', -63),
(464, NULL, 1, 1, 0, 'b0:f9:63:0b:7a:46', 'H3C_0B7A44', -84),
(465, NULL, 1, 1, 0, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -66),
(466, NULL, 1, 2, 0, 'ca:8f:26:d4:ba:bc', 'tsy_public', -89),
(467, NULL, 1, 2, 0, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -48),
(468, NULL, 1, 2, 0, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -53),
(469, NULL, 1, 2, 0, 'b0:f9:63:0b:7a:46', 'H3C_0B7A44', -89),
(470, NULL, 1, 2, 0, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -78),
(471, NULL, 1, 2, 0, '74:ff:4c:78:9f:2c', 'tsy_201', -91),
(472, NULL, 1, 2, 0, '7c:52:59:3d:b0:94', 'zlz', -53),
(473, NULL, 1, 3, 0, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -54),
(474, NULL, 1, 3, 0, '7c:52:59:3d:b0:94', 'zlz', -67),
(475, NULL, 1, 3, 0, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -38),
(476, NULL, 1, 3, 0, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -79),
(477, NULL, 1, 3, 0, '70:af:6a:49:e8:d1', '360WiFi-49E8D1', -88),
(478, NULL, 1, 4, 0, '7c:03:c9:c5:fe:02', 'ChinaNet-EX4b', -85),
(479, NULL, 1, 4, 0, '7c:52:59:3d:b0:94', 'zlz', -67),
(480, NULL, 1, 4, 0, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -71),
(481, NULL, 1, 4, 0, 'ec:23:7b:37:bb:58', 'ChinaNet-qPvD', -90),
(482, NULL, 1, 4, 0, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -56),
(483, NULL, 1, 5, 0, 'b8:f8:83:34:be:75', 'xiaohongmao', -89),
(484, NULL, 1, 5, 0, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -81),
(485, NULL, 1, 5, 0, '2c:61:04:f6:48:ac', '360WiFi-F648AC', -84),
(486, NULL, 1, 5, 0, 'd8:32:14:a4:0c:b0', 'liufangyu', -89),
(487, NULL, 1, 5, 0, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -51),
(488, NULL, 1, 5, 0, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -68),
(489, NULL, 1, 5, 0, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -86),
(490, NULL, 1, 5, 0, '08:e8:4f:f9:1b:5c', 'ChinaNet-2YKZ', -90),
(491, NULL, 1, 5, 0, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -89),
(492, NULL, 1, 5, 0, '7c:52:59:3d:b0:94', 'zlz', -64),
(493, NULL, 1, 5, 1, '2c:18:75:68:37:26', 'CU_7FZk', -89),
(494, NULL, 1, 5, 1, '7c:52:59:3d:b0:94', 'zlz', -72),
(495, NULL, 1, 5, 1, 'c8:8f:26:d5:ba:bc', '666', -90),
(496, NULL, 1, 5, 1, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -47),
(497, NULL, 1, 5, 1, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -82),
(498, NULL, 1, 5, 1, 'ca:8f:26:d4:ba:bc', 'tsy_public', -91),
(499, NULL, 1, 5, 1, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -72),
(500, NULL, 1, 5, 1, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -85),
(501, NULL, 1, 5, 1, '84:74:60:d8:c8:20', 'ChinaNet-axgt', -90),
(502, NULL, 1, 5, 1, 'b8:f8:83:34:be:75', 'xiaohongmao', -87),
(503, NULL, 1, 5, 2, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -85),
(504, NULL, 1, 5, 2, '00:25:12:62:61:7c', 'Wireless', -89),
(505, NULL, 1, 5, 2, '7c:52:59:3d:b0:94', 'zlz', -66),
(506, NULL, 1, 5, 2, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -76),
(507, NULL, 1, 5, 2, 'a8:e2:c3:c4:84:88', 'ChinaNet-RtrC', -84),
(508, NULL, 1, 5, 2, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -57),
(509, NULL, 1, 5, 2, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -74),
(510, NULL, 1, 5, 2, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -76),
(511, NULL, 1, 5, 2, 'ec:23:7b:47:20:68', 'ChinaNet-SAXM', -83),
(512, NULL, 1, 5, 2, 'f8:c3:9e:ad:1f:41', '', -83),
(513, NULL, 1, 5, 2, '7c:03:c9:c5:fe:ec', 'ChinaNet-CTeD', -89),
(514, NULL, 1, 5, 2, '18:13:2d:82:6b:68', 'ChinaNet-JTMk', -88),
(515, NULL, 1, 5, 3, '00:25:12:62:61:79', 'Wireless', -91),
(516, NULL, 1, 5, 3, 'e4:f3:f5:a8:eb:26', 'MERCURY_EB26', -86),
(517, NULL, 1, 5, 3, '50:bd:5f:1a:3d:e5', 'TP-5510', -88),
(518, NULL, 1, 5, 3, '00:25:12:62:61:7c', 'Wireless', -90),
(519, NULL, 1, 5, 3, '6c:59:40:ec:4b:76', 'MERCURY_4B76', -88),
(520, NULL, 1, 5, 3, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -81),
(521, NULL, 1, 5, 3, 'b8:f8:83:34:be:75', 'xiaohongmao', -79),
(522, NULL, 1, 5, 3, 'a8:e2:c3:c4:84:88', 'ChinaNet-RtrC', -79),
(523, NULL, 1, 5, 3, '7c:52:59:3d:b0:94', 'zlz', -74),
(524, NULL, 1, 5, 3, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -78),
(525, NULL, 1, 5, 3, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -69),
(526, NULL, 1, 5, 3, 'ec:23:7b:47:ac:d8', 'ChinaNet-ZMtv', -84),
(527, NULL, 1, 5, 3, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -70),
(528, NULL, 1, 5, 3, 'e4:bd:4b:f2:e8:a8', 'ChinaNet-hGgf', -83),
(529, NULL, 1, 5, 3, 'bc:46:99:d1:04:be', 'LeXueJiaoYu3', -89),
(530, NULL, 1, 5, 3, '9c:9c:40:bc:08:31', 'ChinaNet-dq2b', -86),
(531, NULL, 1, 5, 3, 'c0:61:18:53:0c:bf', 'LeXueJiaoYu', -89),
(532, NULL, 1, 5, 4, 'e4:d3:32:90:4a:b6', 'TTT', -90),
(533, NULL, 1, 5, 4, '7c:52:59:3d:b0:94', 'zlz', -76),
(534, NULL, 1, 5, 4, '50:bd:5f:1a:3d:e5', 'TP-5510', -88),
(535, NULL, 1, 5, 4, 'b8:f8:83:34:be:75', 'xiaohongmao', -83),
(536, NULL, 1, 5, 4, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -91),
(537, NULL, 1, 5, 4, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -64),
(538, NULL, 1, 5, 4, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -75),
(539, NULL, 1, 5, 4, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -79),
(540, NULL, 1, 5, 4, 'cc:2d:21:86:0c:21', 'ZYB', -83),
(541, NULL, 1, 4, 4, '7c:52:59:3d:b0:94', 'zlz', -82),
(542, NULL, 1, 4, 4, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -77),
(543, NULL, 1, 4, 4, '50:bd:5f:1a:3d:e5', 'TP-5510', -91),
(544, NULL, 1, 4, 4, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -85),
(545, NULL, 1, 4, 4, '18:13:2d:82:55:d0', 'ChinaNet-YDjS', -85),
(546, NULL, 1, 4, 4, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -61),
(547, NULL, 1, 4, 4, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -69),
(548, NULL, 1, 4, 4, 'ec:23:7b:47:b2:70', 'ChinaNet-t4ut', -79),
(549, NULL, 1, 4, 4, '84:74:60:d8:c8:20', 'ChinaNet-axgt', -92),
(550, NULL, 1, 4, 4, 'f8:c3:9e:ad:1f:3c', 'HUAWEI-MMALD5', -78),
(551, NULL, 1, 4, 4, '84:74:60:da:07:b0', 'ChinaNet-JRRY', -82),
(552, NULL, 1, 4, 3, '50:bd:5f:1a:3d:e5', 'TP-5510', -84),
(553, NULL, 1, 4, 3, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -82),
(554, NULL, 1, 4, 3, 'b8:f8:83:34:be:75', 'xiaohongmao', -85),
(555, NULL, 1, 4, 3, '7c:52:59:3d:b0:94', 'zlz', -75),
(556, NULL, 1, 4, 3, '74:ff:4c:78:9f:2c', 'tsy_201', -89),
(557, NULL, 1, 4, 3, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -58),
(558, NULL, 1, 4, 3, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -65),
(559, NULL, 1, 4, 3, '9c:9c:40:bc:08:31', 'ChinaNet-dq2b', -89),
(560, NULL, 1, 4, 3, 'bc:46:99:d1:04:be', 'LeXueJiaoYu3', -74),
(561, NULL, 1, 4, 2, 'c0:61:18:53:0c:bf', 'LeXueJiaoYu', -80),
(562, NULL, 1, 4, 2, 'b8:f8:83:34:be:75', 'xiaohongmao', -87),
(563, NULL, 1, 4, 2, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -89),
(564, NULL, 1, 4, 2, '7c:52:59:3d:b0:94', 'zlz', -68),
(565, NULL, 1, 4, 2, '80:89:17:89:c5:80', 'LeXueJiaoYu 2', -88),
(566, NULL, 1, 4, 2, 'a8:e2:c3:c4:84:88', 'ChinaNet-RtrC', -89),
(567, NULL, 1, 4, 2, 'fc:94:ce:fd:c7:f0', 'ChinaNet-XJDK', -80),
(568, NULL, 1, 4, 2, '88:cc:45:f1:ea:90', 'tsy_F1EA90', -88),
(569, NULL, 1, 4, 2, '18:52:82:af:34:8d', 'ChinaNet-sJTH', -89),
(570, NULL, 1, 4, 2, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -59),
(571, NULL, 1, 4, 2, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -67),
(572, NULL, 1, 4, 2, 'f8:c3:9e:ad:1f:41', '', -87),
(573, NULL, 1, 4, 2, '6c:59:40:ec:4b:76', 'MERCURY_4B76', -87),
(574, NULL, 1, 4, 1, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -57),
(575, NULL, 1, 4, 1, '28:6c:07:e1:6a:83', 'Xiaomi_6A82', -91),
(576, NULL, 1, 4, 1, '7c:52:59:3d:b0:94', 'zlz', -72),
(577, NULL, 1, 4, 1, 'f8:c3:9e:ad:1f:41', '', -91),
(578, NULL, 1, 4, 1, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -77),
(579, NULL, 1, 4, 1, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -46),
(580, NULL, 1, 3, 1, 'b0:df:c1:93:d0:50', 'Tenda_AAAA', -90),
(581, NULL, 1, 3, 1, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -57),
(582, NULL, 1, 3, 1, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -79),
(583, NULL, 1, 3, 1, '7c:52:59:3d:b0:94', 'zlz', -54),
(584, NULL, 1, 3, 1, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -30),
(585, NULL, 1, 3, 2, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -47),
(586, NULL, 1, 3, 2, 'cc:2d:21:86:0c:21', 'ZYB', -80),
(587, NULL, 1, 3, 2, '7c:52:59:3d:b0:94', 'zlz', -76),
(588, NULL, 1, 3, 2, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -70),
(589, NULL, 1, 3, 3, '7c:52:59:3d:b0:94', 'zlz', -65),
(590, NULL, 1, 3, 3, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -55),
(591, NULL, 1, 3, 3, 'f0:10:ab:68:2e:08', 'CMCC-fc3c', -84),
(592, NULL, 1, 3, 3, '9c:9c:40:78:98:c1', 'ChinaNet-yAbC', -92),
(593, NULL, 1, 3, 3, 'b8:f8:83:34:be:75', 'xiaohongmao', -79),
(594, NULL, 1, 3, 3, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -78),
(595, NULL, 1, 3, 3, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -81),
(596, NULL, 1, 3, 3, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -46),
(597, NULL, 1, 3, 4, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -72),
(598, NULL, 1, 3, 4, '7c:52:59:3d:b0:94', 'zlz', -69),
(599, NULL, 1, 3, 4, '50:bd:5f:1a:3d:e5', 'TP-5510', -83),
(600, NULL, 1, 3, 4, '7c:52:59:3d:b2:80', 'LJC', -83),
(601, NULL, 1, 3, 4, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -59),
(602, NULL, 1, 3, 4, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -63),
(603, NULL, 1, 3, 4, 'b8:f8:83:34:be:75', 'xiaohongmao', -75),
(604, NULL, 1, 3, 4, 'bc:46:99:81:de:7c', 'TP-LINK_DE7C', -84),
(605, NULL, 1, 3, 4, 'f8:c3:9e:ad:1f:3d', '', -79),
(606, NULL, 1, 3, 4, 'b0:df:c1:93:d0:50', 'Tenda_AAAA', -78),
(607, NULL, 1, 3, 4, 'f8:c3:9e:ad:1f:3c', 'HUAWEI-MMALD5', -77),
(608, NULL, 1, 2, 1, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -35),
(609, NULL, 1, 2, 1, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -49),
(610, NULL, 1, 2, 1, 'b0:f9:63:0b:7a:46', 'H3C_0B7A44', -90),
(611, NULL, 1, 2, 1, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -79),
(612, NULL, 1, 2, 1, '7c:52:59:3d:b0:94', 'zlz', -59),
(613, NULL, 1, 2, 2, 'd8:32:14:a4:0c:b0', 'liufangyu', -87),
(614, NULL, 1, 2, 2, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -39),
(615, NULL, 1, 2, 2, '7c:52:59:3d:b0:94', 'zlz', -58),
(616, NULL, 1, 2, 2, 'b8:f8:83:34:be:75', 'xiaohongmao', -86),
(617, NULL, 1, 2, 2, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -59),
(618, NULL, 1, 2, 2, 'cc:2d:21:86:0c:21', 'ZYB', -88),
(619, NULL, 1, 2, 2, 'b8:f8:83:34:be:75', 'xiaohongmao', -86),
(620, NULL, 1, 2, 3, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -80),
(621, NULL, 1, 2, 3, '7c:52:59:3d:b0:94', 'zlz', -68),
(622, NULL, 1, 2, 3, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -53),
(623, NULL, 1, 2, 3, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -66),
(624, NULL, 1, 2, 3, 'f0:10:ab:68:2e:08', 'CMCC-fc3c', -92),
(625, NULL, 1, 2, 3, 'b8:f8:83:34:be:75', 'xiaohongmao', -86),
(626, NULL, 1, 2, 3, 'cc:2d:21:86:0c:21', 'ZYB', -82),
(627, NULL, 1, 2, 3, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -89),
(628, NULL, 1, 2, 3, 'f8:c3:9e:ad:1f:41', '', -82),
(629, NULL, 1, 2, 3, 'e4:d3:32:90:4a:b6', 'TTT', -94),
(630, NULL, 1, 2, 4, 'e4:d3:32:90:4a:b6', 'TTT', -83),
(631, NULL, 1, 2, 4, '50:bd:5f:1a:3d:e5', 'TP-5510', -80),
(632, NULL, 1, 2, 4, 'b8:f8:83:34:be:75', 'xiaohongmao', -79),
(633, NULL, 1, 2, 4, 'e4:f3:f5:a8:eb:26', 'MERCURY_EB26', -83),
(634, NULL, 1, 2, 4, '9c:fe:a1:1f:e9:67', 'CMCC-UMJL', -76),
(635, NULL, 1, 2, 4, 'a8:e2:c3:c4:84:88', 'ChinaNet-RtrC', -77),
(636, NULL, 1, 2, 4, '7c:52:59:3d:b0:94', 'zlz', -66),
(637, NULL, 1, 2, 4, '84:74:60:da:07:b0', 'ChinaNet-JRRY', -76),
(638, NULL, 1, 2, 4, 'd8:32:14:a4:0c:b0', 'liufangyu', -75),
(639, NULL, 1, 2, 4, '74:ff:4c:78:9f:2c', 'tsy_201', -84),
(640, NULL, 1, 2, 4, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -51),
(641, NULL, 1, 2, 4, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -73),
(642, NULL, 1, 2, 4, '34:5b:bb:10:84:bd', 'midea_ca_0189', -86),
(643, NULL, 1, 2, 4, 'e4:bd:4b:f2:e8:a8', 'ChinaNet-hGgf', -78),
(644, NULL, 1, 2, 4, 'cc:2d:21:86:0c:21', 'ZYB', -88),
(645, NULL, 1, 2, 4, '9c:9c:40:bc:08:31', 'ChinaNet-dq2b', -78),
(646, NULL, 1, 2, 4, 'b0:df:c1:93:d0:50', 'Tenda_AAAA', -77),
(647, NULL, 1, 2, 4, 'f0:10:ab:68:2e:08', 'CMCC-fc3c', -87),
(648, NULL, 1, 1, 1, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -56),
(649, NULL, 1, 1, 1, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -49),
(650, NULL, 1, 1, 1, '7c:52:59:3d:b0:94', 'zlz', -59),
(651, NULL, 1, 1, 1, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -80),
(652, NULL, 1, 1, 1, 'c0:61:18:53:0c:bf', 'LeXueJiaoYu', -85),
(653, NULL, 1, 1, 2, 'b8:f8:83:34:be:75', 'xiaohongmao', -89),
(654, NULL, 1, 1, 2, '50:bd:5f:1a:3d:e5', 'TP-5510', -87),
(655, NULL, 1, 1, 2, '7c:52:59:3d:b0:94', 'zlz', -61),
(656, NULL, 1, 1, 2, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -62),
(657, NULL, 1, 1, 2, 'f8:c3:9e:ad:1f:3c', 'HUAWEI-MMALD5', -92),
(658, NULL, 1, 1, 2, '9c:9c:40:be:e4:c9', 'ChinaNet-QjSu', -79),
(659, NULL, 1, 1, 2, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -54),
(660, NULL, 1, 1, 3, '7c:52:59:3d:b0:94', 'zlz', -56),
(661, NULL, 1, 1, 3, '06:d3:b0:b2:37:70', 'DIRECT-GVLAPTOP-DB0O', -60),
(662, NULL, 1, 1, 3, '88:cc:45:f2:3e:b0', 'tsy_F23EB0', -41),
(663, NULL, 2, 1, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -55),
(664, NULL, 2, 1, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -73),
(665, NULL, 2, 1, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -51),
(666, NULL, 2, 1, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -66),
(667, NULL, 2, 1, 1, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -87),
(668, NULL, 2, 1, 1, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -92),
(669, NULL, 2, 1, 1, 'c0:70:09:7b:3d:6c', 'ChinaNet-eICQ', -96),
(670, NULL, 2, 1, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -69),
(671, NULL, 2, 1, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -71),
(672, NULL, 2, 1, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -48),
(673, NULL, 2, 1, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -51),
(674, NULL, 2, 1, 2, 'f4:74:88:35:c3:ac', 'è����ս', -89),
(675, NULL, 2, 1, 2, 'a0:d8:07:40:bd:b0', 'huahua', -90),
(676, NULL, 2, 1, 2, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -91),
(677, NULL, 2, 1, 2, 'a0:d8:07:40:bd:b5', '', -91),
(678, NULL, 2, 1, 2, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -93),
(679, NULL, 2, 1, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -55),
(680, NULL, 2, 1, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -42),
(681, NULL, 2, 1, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -46),
(682, NULL, 2, 1, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -74),
(683, NULL, 2, 1, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -78),
(684, NULL, 2, 1, 3, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -88),
(685, NULL, 2, 1, 3, 'f4:74:88:35:c3:ae', '', -89),
(686, NULL, 2, 1, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -92),
(687, NULL, 2, 1, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -94),
(688, NULL, 2, 3, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -39),
(689, NULL, 2, 3, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -75),
(690, NULL, 2, 3, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -41),
(691, NULL, 2, 3, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -58),
(692, NULL, 2, 3, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -84),
(693, NULL, 2, 3, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -88),
(694, NULL, 2, 3, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -92),
(695, NULL, 2, 3, 3, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -92),
(696, NULL, 2, 3, 3, 'a4:93:3f:6c:bf:88', 'yangjiajun', -95),
(697, NULL, 2, 3, 3, '1c:d5:e2:e1:e9:fe', 'ChinaNet-3PdZ', -96),
(698, NULL, 2, 2, 3, 'f4:74:88:35:c3:ae', '', -80),
(699, NULL, 2, 2, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -39),
(700, NULL, 2, 2, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -71),
(701, NULL, 2, 2, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -82),
(702, NULL, 2, 2, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -86),
(703, NULL, 2, 2, 3, 'a0:d8:07:40:bd:b1', '', -94),
(704, NULL, 2, 2, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -95),
(705, NULL, 2, 2, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -96),
(706, NULL, 2, 2, 3, 'a4:93:3f:6c:bf:88', 'yangjiajun', -97),
(707, NULL, 2, 2, 3, 'a0:d8:07:40:bd:b5', '', -97),
(708, NULL, 2, 2, 3, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -98),
(709, NULL, 2, 2, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -47),
(710, NULL, 2, 2, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -74),
(711, NULL, 2, 2, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -56),
(712, NULL, 2, 2, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -57),
(713, NULL, 2, 2, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -65),
(714, NULL, 2, 2, 1, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -80),
(715, NULL, 2, 2, 1, 'f4:74:88:35:c3:ae', '', -89),
(716, NULL, 2, 2, 1, 'c0:70:09:7b:3d:6c', 'ChinaNet-eICQ', -93),
(717, NULL, 2, 2, 1, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -95),
(718, NULL, 2, 3, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -52),
(719, NULL, 2, 3, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -82),
(720, NULL, 2, 3, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -53),
(721, NULL, 2, 3, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -81),
(722, NULL, 2, 3, 1, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -84),
(723, NULL, 2, 3, 1, 'd4:b7:61:a5:84:77', 'EZVIZ_C87998841', -87),
(724, NULL, 2, 3, 1, 'f4:74:88:35:c3:ae', '', -94),
(725, NULL, 2, 3, 1, 'f4:74:88:35:c3:ac', 'è����ս', -94),
(726, NULL, 2, 3, 1, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -95),
(727, NULL, 2, 3, 2, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -65),
(728, NULL, 2, 3, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -47),
(729, NULL, 2, 3, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -51),
(730, NULL, 2, 3, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -74),
(731, NULL, 2, 3, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -75),
(732, NULL, 2, 3, 2, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -85),
(733, NULL, 2, 3, 2, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -94),
(734, NULL, 2, 3, 2, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -95),
(735, NULL, 2, 3, 2, 'a4:93:3f:6c:bf:88', 'yangjiajun', -96),
(736, NULL, 2, 2, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -52),
(737, NULL, 2, 2, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -72),
(738, NULL, 2, 2, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -61),
(739, NULL, 2, 2, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -80),
(740, NULL, 2, 2, 2, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -88),
(741, NULL, 2, 2, 2, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -93),
(742, NULL, 2, 2, 2, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -90),
(743, NULL, 2, 2, 2, 'a4:93:3f:6c:bf:88', 'yangjiajun', -95),
(744, NULL, 2, 2, 2, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -97),
(745, NULL, 3, 0, 0, 'a0:63:91:a6:52:e5', 'VGL-AC', -61),
(746, NULL, 3, 0, 0, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -70),
(747, NULL, 3, 0, 0, 'a0:63:91:a6:52:e6', 'VGL-AP', -56),
(748, NULL, 3, 0, 0, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -90),
(749, NULL, 3, 0, 0, 'f4:74:88:35:c3:ac', 'è����ս', -96),
(750, NULL, 3, 0, 0, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -88),
(751, NULL, 3, 0, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -47),
(752, NULL, 3, 0, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -56),
(753, NULL, 3, 0, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -76),
(754, NULL, 3, 0, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -78),
(755, NULL, 3, 0, 1, 'f4:74:88:35:c3:ac', 'è����ս', -89),
(756, NULL, 3, 0, 1, 'f4:74:88:35:c3:ae', '', -90),
(757, NULL, 3, 0, 1, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -90),
(758, NULL, 3, 0, 1, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -91),
(759, NULL, 3, 0, 1, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -63),
(760, NULL, 3, 0, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -50),
(761, NULL, 3, 0, 2, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -64),
(762, NULL, 3, 0, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -83),
(763, NULL, 3, 0, 2, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -92),
(764, NULL, 3, 0, 2, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -94),
(765, NULL, 3, 0, 2, 'a0:d8:07:40:bd:b0', 'huahua', -97),
(766, NULL, 3, 0, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -71),
(767, NULL, 3, 0, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -47),
(768, NULL, 3, 0, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -46),
(769, NULL, 3, 0, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -56),
(770, NULL, 3, 0, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -43),
(771, NULL, 3, 0, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -85),
(772, NULL, 3, 0, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -88),
(773, NULL, 3, 0, 3, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -91),
(774, NULL, 3, 0, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -96),
(775, NULL, 3, 0, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -75),
(776, NULL, 3, 0, 4, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -59),
(777, NULL, 3, 0, 4, 'a0:63:91:a6:52:e6', 'VGL-AP', -33),
(778, NULL, 3, 0, 4, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -80),
(779, NULL, 3, 0, 4, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -83),
(780, NULL, 3, 0, 4, 'a0:63:91:a6:52:e5', 'VGL-AC', -47),
(781, NULL, 3, 0, 4, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -92),
(782, NULL, 3, 0, 4, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -92),
(783, NULL, 3, 0, 4, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -94),
(784, NULL, 3, 0, 4, 'f4:74:88:35:c3:ac', 'è����ս', -95),
(785, NULL, 3, 0, 4, 'a4:93:3f:6c:bf:88', 'yangjiajun', -95),
(786, NULL, 3, 0, 4, 'c0:70:09:7b:3d:6c', 'ChinaNet-eICQ', -96),
(787, NULL, 3, 0, 4, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -78),
(788, NULL, 3, 1, 4, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -76),
(789, NULL, 3, 1, 4, 'a0:63:91:a6:52:e6', 'VGL-AP', -49),
(790, NULL, 3, 1, 4, 'a0:63:91:a6:52:e5', 'VGL-AC', -38),
(791, NULL, 3, 1, 4, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -72),
(792, NULL, 3, 1, 4, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -85),
(793, NULL, 3, 1, 4, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -89),
(794, NULL, 3, 1, 4, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -91),
(795, NULL, 3, 1, 4, '54:c4:15:97:78:21', 'ezviz_97781d', -91),
(796, NULL, 3, 1, 4, 'a4:93:3f:6c:bf:88', 'yangjiajun', -93),
(797, NULL, 3, 1, 4, '8c:a6:df:96:0c:b5', '王洪兵', -93),
(798, NULL, 3, 1, 4, '28:6c:07:69:ce:34', '淡淡的丹丹', -93),
(799, NULL, 3, 1, 4, '1c:d5:e2:e1:e9:fe', 'ChinaNet-3PdZ', -93),
(800, NULL, 3, 1, 4, 'ec:8a:c7:12:a6:cd', 'ChinaNet-bA5s', -95),
(801, NULL, 3, 1, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -40),
(802, NULL, 3, 1, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -73),
(803, NULL, 3, 1, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -76),
(804, NULL, 3, 1, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -40),
(805, NULL, 3, 1, 3, 'f4:74:88:35:c3:ac', 'è����ս', -80),
(806, NULL, 3, 1, 3, 'f4:74:88:35:c3:ae', '', -80),
(807, NULL, 3, 1, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -90),
(808, NULL, 3, 1, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -87),
(809, NULL, 3, 1, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -93),
(810, NULL, 3, 1, 3, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -95),
(811, NULL, 3, 1, 3, '54:c4:15:97:78:21', 'ezviz_97781d', -96),
(812, NULL, 3, 1, 3, '28:6c:07:69:ce:34', '淡淡的丹丹', -98),
(813, NULL, 3, 1, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -69),
(814, NULL, 3, 1, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -64),
(815, NULL, 3, 1, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -50),
(816, NULL, 3, 1, 2, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -61),
(817, NULL, 3, 1, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -74),
(818, NULL, 3, 1, 2, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -89),
(819, NULL, 3, 1, 2, 'a4:93:3f:6c:bf:88', 'yangjiajun', -93),
(820, NULL, 3, 1, 2, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -95),
(821, NULL, 3, 1, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -49),
(822, NULL, 3, 1, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -52),
(823, NULL, 3, 1, 1, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -63),
(824, NULL, 3, 1, 1, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -89),
(825, NULL, 3, 1, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -75),
(826, NULL, 3, 1, 1, 'f4:74:88:35:c3:ae', '', -90),
(827, NULL, 3, 1, 1, 'f4:74:88:35:c3:ac', 'è����ս', -91),
(828, NULL, 3, 1, 1, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -93),
(829, NULL, 3, 1, 1, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -95),
(830, NULL, 3, 1, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -70),
(831, NULL, 3, 1, 0, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -63),
(832, NULL, 3, 1, 0, 'a0:63:91:a6:52:e6', 'VGL-AP', -56),
(833, NULL, 3, 1, 0, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -79),
(834, NULL, 3, 1, 0, '08:10:79:11:ba:be', 'Netcore_11BABE', -85),
(835, NULL, 3, 1, 0, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -79),
(836, NULL, 3, 1, 0, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -88),
(837, NULL, 3, 1, 0, 'f4:74:88:35:c3:ac', 'è����ս', -95),
(838, NULL, 3, 1, 0, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -95),
(839, NULL, 3, 1, 0, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -95),
(840, NULL, 3, 1, 0, 'f4:74:88:35:c3:ae', '', -95),
(841, NULL, 3, 1, 0, 'a0:63:91:a6:52:e5', 'VGL-AC', -62),
(842, NULL, 3, 2, 0, 'a0:63:91:a6:52:e6', 'VGL-AP', -56),
(843, NULL, 3, 2, 0, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -74),
(844, NULL, 3, 2, 0, 'a0:63:91:a6:52:e5', 'VGL-AC', -51),
(845, NULL, 3, 2, 0, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -78),
(846, NULL, 3, 2, 0, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -84),
(847, NULL, 3, 2, 0, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -89),
(848, NULL, 3, 2, 0, 'a0:d8:07:40:bd:b1', '', -93),
(849, NULL, 3, 2, 0, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -93),
(850, NULL, 3, 2, 0, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -94),
(851, NULL, 3, 2, 0, 'a0:d8:07:40:bd:b0', 'huahua', -94),
(852, NULL, 3, 2, 0, '8c:a6:df:96:0c:b5', '王洪兵', -97),
(853, NULL, 3, 2, 1, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -64),
(854, NULL, 3, 2, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -52),
(855, NULL, 3, 2, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -70),
(856, NULL, 3, 2, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -56),
(857, NULL, 3, 2, 1, 'd4:b7:61:a5:84:77', 'EZVIZ_C87998841', -89),
(858, NULL, 3, 2, 1, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -85),
(859, NULL, 3, 2, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -91),
(860, NULL, 3, 2, 1, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -91),
(861, NULL, 3, 2, 1, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -91),
(862, NULL, 3, 2, 1, 'f4:74:88:35:c3:ae', '', -95),
(863, NULL, 3, 2, 1, 'f4:74:88:35:c3:ac', 'è����ս', -96),
(864, NULL, 3, 2, 1, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -97),
(865, NULL, 3, 2, 1, '8c:a6:df:96:0c:b5', '王洪兵', -98),
(866, NULL, 3, 2, 1, 'a4:93:3f:6c:bf:88', 'yangjiajun', -98),
(867, NULL, 3, 2, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -49),
(868, NULL, 3, 2, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -52),
(869, NULL, 3, 2, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -86),
(870, NULL, 3, 2, 2, 'f4:74:88:35:c3:ae', '', -87),
(871, NULL, 3, 2, 2, 'f4:74:88:35:c3:ac', 'è����ս', -89),
(872, NULL, 3, 2, 2, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -91),
(873, NULL, 3, 2, 2, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -93),
(874, NULL, 3, 2, 2, 'a0:d8:07:40:bd:b1', '', -93),
(875, NULL, 3, 2, 2, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -95),
(876, NULL, 3, 2, 2, 'a4:93:3f:6c:bf:88', 'yangjiajun', -95),
(877, NULL, 3, 2, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -72),
(878, NULL, 3, 2, 2, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -61),
(879, NULL, 3, 2, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -68),
(880, NULL, 3, 2, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -38),
(881, NULL, 3, 2, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -85),
(882, NULL, 3, 2, 3, 'd0:0e:d9:97:b3:d7', 'ChinaNet-CJuX', -92),
(883, NULL, 3, 2, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -93),
(884, NULL, 3, 2, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -45),
(885, NULL, 3, 2, 3, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -97),
(886, NULL, 3, 2, 3, '28:6c:07:69:ce:34', '淡淡的丹丹', -97),
(887, NULL, 3, 2, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -88),
(888, NULL, 3, 2, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -68),
(889, NULL, 3, 2, 4, 'a0:63:91:a6:52:e5', 'VGL-AC', -46),
(890, NULL, 3, 2, 4, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -88),
(891, NULL, 3, 2, 4, 'd0:0e:d9:97:b3:d7', 'ChinaNet-CJuX', -88),
(892, NULL, 3, 2, 4, 'a4:93:3f:6c:bf:88', 'yangjiajun', -92),
(893, NULL, 3, 2, 4, '54:c4:15:97:78:1f', 'ezviz_97781d_5G', -92),
(894, NULL, 3, 2, 4, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -93),
(895, NULL, 3, 2, 4, 'ec:8a:c7:12:a6:cd', 'ChinaNet-bA5s', -94),
(896, NULL, 3, 2, 4, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -60),
(897, NULL, 3, 2, 4, '28:6c:07:69:ce:34', '淡淡的丹丹', -96),
(898, NULL, 3, 2, 4, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -97),
(899, NULL, 3, 2, 4, 'a0:d8:07:40:bd:b0', 'huahua', -97),
(900, NULL, 3, 2, 4, 'a0:63:91:a6:52:e6', 'VGL-AP', -52),
(901, NULL, 3, 2, 4, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -87),
(902, NULL, 3, 3, 4, 'a0:63:91:a6:52:e5', 'VGL-AC', -30),
(903, NULL, 3, 3, 4, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -65),
(904, NULL, 3, 3, 4, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -77),
(905, NULL, 3, 3, 4, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -78),
(906, NULL, 3, 3, 4, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -88),
(907, NULL, 3, 3, 4, 'f4:74:88:35:c3:ac', 'è����ս', -90),
(908, NULL, 3, 3, 4, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -91),
(909, NULL, 3, 3, 4, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -92),
(910, NULL, 3, 3, 4, 'f4:74:88:35:c3:ae', '', -92),
(911, NULL, 3, 3, 4, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -96),
(912, NULL, 3, 3, 4, '28:6c:07:69:ce:34', '淡淡的丹丹', -97),
(913, NULL, 3, 3, 4, '8c:a6:df:96:0c:b5', '王洪兵', -97),
(914, NULL, 3, 3, 4, 'a0:63:91:a6:52:e6', 'VGL-AP', -40),
(915, NULL, 3, 3, 3, 'a0:63:91:a6:52:e6', 'VGL-AP', -36),
(916, NULL, 3, 3, 3, 'a0:63:91:a6:52:e5', 'VGL-AC', -38),
(917, NULL, 3, 3, 3, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -83),
(918, NULL, 3, 3, 3, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -85),
(919, NULL, 3, 3, 3, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -88),
(920, NULL, 3, 3, 3, 'f4:74:88:35:c3:ae', '', -89),
(921, NULL, 3, 3, 3, 'f6:74:88:35:c3:ac', '猫狗大战', -89),
(922, NULL, 3, 3, 3, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -90),
(923, NULL, 3, 3, 3, 'f4:74:88:35:c3:ac', 'è����ս', -90),
(924, NULL, 3, 3, 3, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -91),
(925, NULL, 3, 3, 3, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -63),
(926, NULL, 3, 3, 2, 'a0:63:91:a6:52:e6', 'VGL-AP', -55),
(927, NULL, 3, 3, 2, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -71),
(928, NULL, 3, 3, 2, 'a0:63:91:a6:52:e5', 'VGL-AC', -51),
(929, NULL, 3, 3, 2, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -73),
(930, NULL, 3, 3, 2, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -86),
(931, NULL, 3, 3, 2, 'f4:74:88:35:c3:ac', 'è����ս', -92),
(932, NULL, 3, 3, 2, '54:c4:15:aa:6d:ff', 'ezviz_aa6dfd', -94),
(933, NULL, 3, 3, 2, 'a0:d8:07:40:bd:b5', '', -96),
(934, NULL, 3, 3, 2, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -72),
(935, NULL, 3, 3, 1, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -79),
(936, NULL, 3, 3, 1, 'a0:63:91:a6:52:e5', 'VGL-AC', -49),
(937, NULL, 3, 3, 1, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -76),
(938, NULL, 3, 3, 1, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -87),
(939, NULL, 3, 3, 1, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -88),
(940, NULL, 3, 3, 1, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -93),
(941, NULL, 3, 3, 1, 'fc:d7:33:d7:30:fe', 'TP-LINK_30FE', -94),
(942, NULL, 3, 3, 1, 'f4:74:88:35:c3:ac', 'è����ս', -94),
(943, NULL, 3, 3, 1, 'a4:93:3f:6c:bf:88', 'yangjiajun', -95),
(944, NULL, 3, 3, 1, 'a0:63:91:a6:52:e6', 'VGL-AP', -65),
(945, NULL, 3, 3, 0, 'e0:28:61:86:01:30', 'ChinaNet-wnfz', -75),
(946, NULL, 3, 3, 0, '24:69:68:71:ef:3e', 'TP-LINK_1111111', -78),
(947, NULL, 3, 3, 0, 'a0:63:91:a6:52:e5', 'VGL-AC', -61),
(948, NULL, 3, 3, 0, 'a0:63:91:a6:52:e6', 'VGL-AP', -65),
(949, NULL, 3, 3, 0, 'dc:fe:18:01:09:ac', 'TP-LINK_09AC', -82),
(950, NULL, 3, 3, 0, '30:fc:68:dc:37:c7', 'TP-LINK_sss', -95),
(951, NULL, 3, 3, 0, '98:f4:28:34:45:a3', 'ChinaNet-qfND', -84);

-- --------------------------------------------------------

--
-- 表的结构 `avatars`
--

CREATE TABLE `avatars` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `imgpath` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `avatars`
--

INSERT INTO `avatars` (`id`, `user`, `imgpath`) VALUES
(1, 'lucas', './avatars/lucas.jpg');

-- --------------------------------------------------------

--
-- 表的结构 `friends`
--

CREATE TABLE `friends` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `friend` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `friends`
--

INSERT INTO `friends` (`id`, `user`, `friend`) VALUES
(10, 'lucas', 'GummyBear'),
(11, 'GummyBear', 'lucas'),
(12, 'GummyBear', 'lucas'),
(13, 'lucas', 'linn'),
(14, 'linn', 'lxt'),
(15, 'lucas', 'lucas3'),
(16, 'lucas3', 'lucas');

-- --------------------------------------------------------

--
-- 表的结构 `locations`
--

CREATE TABLE `locations` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `locx` float NOT NULL,
  `locy` float NOT NULL,
  `vzoneid` int(11) NOT NULL,
  `vanish` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `locations`
--

INSERT INTO `locations` (`id`, `user`, `locx`, `locy`, `vzoneid`, `vanish`) VALUES
(1, 'lucas', 1.5, 1.5, 1, 0),
(2, 'lucas2', 2, 2, 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `rooms`
--

CREATE TABLE `rooms` (
  `id` int(11) NOT NULL,
  `vzoneid` int(11) NOT NULL,
  `roomid` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `rooms`
--

INSERT INTO `rooms` (`id`, `vzoneid`, `roomid`) VALUES
(1, 1, '120445940596738');

-- --------------------------------------------------------

--
-- 表的结构 `sessions`
--

CREATE TABLE `sessions` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `uuid` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `sessions`
--

INSERT INTO `sessions` (`id`, `user`, `uuid`) VALUES
(7, 'Name555', '36a134e6-ebbd-e00a-f7b9-807782d6935f'),
(22, 'Name55', '0297aca7-021a-7325-cfd4-2e85520a1118'),
(104, 'Name1111', 'c71d8148-7f8c-fd12-4974-95d278e4a679'),
(132, 'null', '66351b53-3411-ab47-399e-9fc5cd4d0f6b'),
(220, 'linnn', '6dd5eff8-f55e-bcf9-5c8f-dd7e22ab7aee'),
(227, 'linnnn', '11bceaa7-b2a6-1176-b3a6-49579c94e1c0'),
(230, 'lucas1244', 'e93e34ed-5b0a-c948-7cc3-79a04466dea9'),
(236, 'test1111', '73ce4861-1799-8b26-044a-97280818ca9b'),
(248, 'testreg', 'db3521f1-45e6-51e2-e32a-14b45291c958'),
(252, 'test2333', '5cd8bfb3-01b0-3024-395a-a0139c3167aa'),
(254, 'Name', 'c62aabba-752a-1eb6-fbd6-fea1c99f2bda'),
(345, 'guigui', '1e913347-395c-2b1a-6837-a5b9452eb83f'),
(364, 'lxt', 'fa26ab42-ecd4-d8f1-804a-93532596cae2'),
(370, 'linn', '00570581-5acc-b9d5-2999-39d548ab3a2e'),
(371, 'lucas2', 'dbc4acdc-0009-c42c-d814-9a0aa6411e5c'),
(374, 'lucas3', 'a01f11ab-42cb-ac54-3311-fc661bea58fb'),
(375, 'GummyBear', '3c724b03-96c8-2055-03ab-7cb7e058bafa'),
(395, 'lucas', '24fa8892-7ebc-5d4f-83d8-ef50636a0f06');

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `phone` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `user`, `pass`, `phone`) VALUES
(15, 'Name555', '123563', '15199257365'),
(18, 'Name55', '1235635', '13598875536'),
(21, 'Name1', '1235635', '13598875536'),
(22, 'Name555555', '1235635', '13555555555'),
(23, 'Name1', '1235635', '13598875536'),
(24, 'Name', '123456', '1355555555'),
(25, 'Name11', '123456', '15366666666'),
(26, 'Name2', '123456', '135'),
(27, 'Name3', '123456', '135'),
(28, 'Name111', '123456', '13531546548'),
(29, 'Name1111', '123456', '13531546548'),
(30, 'null', 'null', 'null'),
(32, 'test2', '19990924', '17621979123'),
(33, 'Name666', '1235635', '13598875536'),
(34, 'linn', '123456', '18800115020'),
(35, 'linnn', '123456', '18800115020'),
(36, 'linnnn', '123456', '18800115920'),
(37, 'lucas1244', '990924', '17621979123'),
(38, 'testtest', '123456', '17621977777'),
(39, 'test1111', '123456', '12312312233'),
(40, 'lucas2', '990924', '12312311123'),
(41, 'testreg', '123456', '11223344443'),
(42, 'testttesttt', '123456', '12341234123'),
(43, 'test2333', '123456', '12341234123'),
(44, 'L', '123456', '15183881327'),
(48, 'GummyBear', '123456', '15183881327'),
(49, 'guigui', '123456', '12345678910'),
(50, 'lxt', '123456', '18800115020'),
(51, 'lxt1', '123456', '18800115020'),
(52, 'lucas3', '990924', '17621979123'),
(53, 'lucas', '123456', '17621979123');

-- --------------------------------------------------------

--
-- 表的结构 `zones`
--

CREATE TABLE `zones` (
  `id` int(11) NOT NULL,
  `zoneid` int(11) NOT NULL,
  `vzoneid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `zones`
--

INSERT INTO `zones` (`id`, `zoneid`, `vzoneid`) VALUES
(1, 1, 1),
(2, 2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ap`
--
ALTER TABLE `ap`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `avatars`
--
ALTER TABLE `avatars`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rooms`
--
ALTER TABLE `rooms`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sessions`
--
ALTER TABLE `sessions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `zones`
--
ALTER TABLE `zones`
  ADD PRIMARY KEY (`id`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `ap`
--
ALTER TABLE `ap`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=952;
--
-- 使用表AUTO_INCREMENT `avatars`
--
ALTER TABLE `avatars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- 使用表AUTO_INCREMENT `friends`
--
ALTER TABLE `friends`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- 使用表AUTO_INCREMENT `locations`
--
ALTER TABLE `locations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- 使用表AUTO_INCREMENT `rooms`
--
ALTER TABLE `rooms`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- 使用表AUTO_INCREMENT `sessions`
--
ALTER TABLE `sessions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=396;
--
-- 使用表AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;
--
-- 使用表AUTO_INCREMENT `zones`
--
ALTER TABLE `zones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
