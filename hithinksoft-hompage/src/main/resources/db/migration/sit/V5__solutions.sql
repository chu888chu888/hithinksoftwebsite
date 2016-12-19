INSERT INTO solution_group (id,name) VALUES (1,'大数据');
INSERT INTO solution_group (id,name) VALUES (2,'云计算');
INSERT INTO solution_group (id,name) VALUES (3,'电商');

INSERT INTO solution(title,solution_group_id,detail)VALUES ('泰康人寿大数据挖掘平台',1,'<h2>泰康人寿大数据挖掘平台</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">案例简介</h4><p>·平台基于hadoop进行保险大数据的采集、处理和挖掘分析，实现保险数据的全链条应用、保险客户的全方位管理、产品生命周期全过程的分析，通过数据推动企业管理，促进利益增长</p><p>· 数据清洗（ETL）使用 Java实现，可维护性更强，扩展性、复用性得到保证</p><p>· 平台的定位清晰，支持数据挖掘、支持数据仓库；使用Spark／MR实现，性能得到保障</p><div style="margin-top: 20px;text-align: center"><img alt="" src="/img/taikang1.jpg" alt=""></div></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">商业价值</h4><p>· 客户健康情况的分析和评估，帮助公司识别理赔风险，减少恶意骗保等欺诈现象</p><p>· 客户行为偏好分析，帮助公司进行差异化营销和服务，提升客户价值，提高客户满意度</p><p>·客户流失特征的挖掘分析，以及客户流失的预测预警，帮助公司保住老客户，及时采取流失应对措施，提高行业的竞争力 </p><div style="margin-top: 20px;text-align: center"><img alt="" src="/img/taikang2.jpg" alt=""></div></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">核心功能</h4><p>· 健康评估、风险预测、营销活动响应</p><p>· 理赔分析、欺诈监测、二次销售预测</p><p>· 客户行为分析、智能推荐、差异化服务</p></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('EMS数仓迁移项目',1,'<h2>EMS数仓迁移项目</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">项目简介</h4><p>·EMS数仓迁移项目是EMS将基于Teradata一体机构筑的BI数仓系统平滑迁移至大数据平台，以此帮助其解决存储空间不足、处理性能不足的问题。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">迁移工作</h4><p>· 新数据平台搭建；软硬件及网络调优及容量规划。</p><p>· 详细整理全部待迁移的数据模型。包括加载数据源、表结构、分区信息、索引信息、数据规模等。</p><p>· 详细整理所有待迁移报表及其相关的脚本。包括临时表、中间表、查询展现方式、调度频率等。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary" th:text="#{view.solution.ems.title3}">数据导入</h4><p th:text="#{view.solution.ems.context5}">1、存量数据的导入</p><p th:text="#{view.solution.ems.context6}">· 利用sqoop2导入至hdfs，通过hive外表完成存量数据导入</p><p th:text="#{view.solution.ems.context7}">· 直接利用sqoop2导入hbase表完成存量数据导入</p><p th:text="#{view.solution.ems.context8}">2、增量数据的导入</p><p th:text="#{view.solution.ems.context9}">· 利用hbase做接口表收集增量数据，每日凌晨对range表进行merge操作完成数据合并。</p></div><div style="margin-bottom: 40px"><h4 class="heading-primary">完成目标</h4><p>满足每天加载上千万条记录，实现报表的经营分析、运营监控、时限监控，交易的即席查询，包括邮件、总包相关日均量550万查询</p></div><p>以上PoC实测基于配置4节点的集群系统，考虑到实际生产环境中并发多任务以及（每小时）最高5000并发访问的要求，配置8个以上计算及存储节点，同时考虑到需有两个节点用于Master及主控服务，迁移项目共配置10个计算及存储节点</p>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('恒丰银行大数据集群实施与运维',1,'<h2>恒丰银行大数据集群实施与运维</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">数据流转与清洗</h4><p>通过ETL（kettle、sqoop2）将RDBMS中的数据抽取到hadoop平台，经过数据稽核建立外表清除脏数据，再结合Hive中自定义UDF、UDAF、UDTF函数实现用户定制数据的转换和查询。</p><div style="margin-top: 20px;text-align: center"><img src="/img/Hengfengbank.jpg"/></div></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">集群运维</h4><p>集群的升级、客户故障排错、统计Hive表结构、PL／SQL的优化、IDC日常巡检（机房清洁巡检、机柜电力巡检、空调设备巡检、设备电源状态巡检）。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">完成目标</h4><p>由于星环科技的TDH较好的支持了SQL2003标准和PL／SQL语法，恒丰银行大数据应用项目从2015年5月开始，仅花费10天时间，完成了数据仓库平台从Oracle产品到Hadoop平台的迁移工作，整体处理能力获得了5-10倍的提升，解决了以往大体量数据统计分析应用相应很慢的问题，极大减轻各应用系统现有数据库的处理资源瓶颈问题。</p></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('平安银行大数据集群实施与运维',1,'<h2>平安银行大数据集群实施与运维</h2><div style="margin-top: 20px"><img alt="" src="/img/PingAnBank.jpg" alt=""></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">POC工作内容</h4><p>1、将网银数据、系统日志、账单文件通过Flume、FTP方式加载到Inceptor中，现有关系型数据库则通过定期的ETL工具sqoop和pentaho加载到Inceptor中，并对导入数据进行数据清洗与稽核。</p><p>2、主备集群HDFS文件数据的同步，增量同步，通过快照功能，同步有改动的文件，确保主备数据完全一致</p><p>3、集群内各组件都要实现HA，包括Inceptor Server， Inceptor Metastore，确保集群的高可用性。</p><p>4、Oracle存储过程的编写和修改维护。</p><p>5、查询与分析数据由Tableau、Cognos、OBIEE生成报表进行前台展现。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">实现目标</h4><p>由于产品支持内存计算方式Inceptor（spark on sql），平台处理银行的数据仓库业务相对于平安银行原系统速度有了十几倍的提高，使平安银行可以轻松完成每天TB级别数据量的分析</p></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('华信云服务',2,'<h2>华信云服务</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">概述</h4><p>华信云服务平台依托于自有的云数据中心，能够针对客户的各种业务提供在线云服务和云咨询服务。在线云服务主要包括云服务器租赁服务、开发管理服务、数据存储服务、企业文件柜应用服务、贸易365业务服务等。云咨询服务主要包括私有云建设提案、应用部署提案、应用云化建设提案、云服务集成提案、云服务IT 运维提案等。</p><p>此外基于专业的云服务实现和提供经验，大连华信可提供专业的云服务、云应用建设开发的技术人才，帮助客户完成其私有云建设和外部云集成等相关业务。</p><div style="margin-top: 20px;text-align: center"><img alt="" src="/img/HuaXinyunservices.jpg" alt=""></div></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">内容</h4><p>依托于云计算支撑平台，开发并构建了云计算运营平台，同时提供EC网站、自助门户功能，并对平台建设的硬件采购和财务结算提供接口。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">系统功能</h4><p>· 提供云计算支撑平台，主要包括IaaS基础服务，提供云服务器的虚拟机服务；提供针对中间件软件环境构筑和存储的PaaS 服务；提供各种典型的SaaS 应用服务。</p><p>· 提供云计算运营平台，能够对云平台运营的各项业务提供支撑。</p><p>· 提供EC 网站和自主门户，使云用户能够自由访问和购买云平台的各项服务。</p></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('华信健康云',2,'<h2>华信健康云</h2><div style="margin-top: 20px;text-align: center"><img alt="" src="/img/jiankangyun1.jpg" alt=""></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">概述</h4><p>华信健康云方案是将近年来IT行业主流的云计算、云存储、大数据、移动互联等技术与可穿戴设备、健康管理等先进理念结合起来，依托大连华信云数据中心强大的计算及存储、分析能力，为用户提供运动、健康、睡眠、饮食等建议和报告，满足人们主动进行健康和运动管理的需求，并通过社交网络中的各种激励形式增加参与人群的粘度，引导和帮助用户树立健康、积极的运动及生活理念。</p><div style="margin-top: 20px;text-align: center"><img alt="" src="/img/jiankangyun2.jpg" alt=""></div></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">内容</h4><p>华信健康云通过采集智能运动终端及便携式医疗终端数据，利用高速发展的移动互联网络，依托大连华信数据中心运行构建了一个软、硬、云结合的健康社交网络平台，向用户提供运动与身体状况管理、保健医疗、社交平台等服务。用户通过佩戴智能健康手环，24小时监测用户的活动状态，记录每天的运动量以及睡眠情况；为用户展现专属健康档案，以直观形象的图表告知用户的身体健康状态。通过华信健康云，用户可以引用个人运动数据分享给其他用户，秀出自我的精彩生活，并且可以随时随地获知朋友们是否在运动、在哪里运动以及运动的效果如何。通过便携式医疗终端采集个人用户健康数据， 为用户建立存储在云端的健康档案，使更高端更全面的健康管理成为可能。华信健康云对用户数据进行分级安全处理并进行存取控制，用户对不同数据可选择不公开、有限公开和全公开三级安全设定。对于不公开的数据系统进行加密处理再传至云端，确保该数据对其他用户而言不可见、不可读；对于有限公开的数据只对用户特定关系人开放；对于全公开的数据则对所有注册用户开放。无论哪种安全级别设定的数据，系统都有存取记录以确保有据可查并可进行审计。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">系统功能</h4><p>· 活动管理</p><p>日常活动记录及活动量分析</p><p>活动计划制定及提醒</p><p>睡眠状况监测及报告</p><p>饮食营养追踪</p><p>· 社交管理</p><p>运动轨迹分享</p><p>运动成绩PK</p><p>运动场所介绍及点评</p><p>发起活动或竞赛</p><p>· 健康管理</p><p>电子健康记录管理</p><p>个人病史及药物过敏史管理</p><p>血压，血糖以及心电波形分析</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">系统特点</h4><p>支持主流可穿戴设备</p><p>支持血压计、血糖仪、心电仪等主流家庭用便携医疗终端</p><p>支持数据采集与上传至华信云服务平台</p><p>支持云端数据存储、清洗、分析、预测与推送</p></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('华药网中国医药城B2C交易平台跨境商城',3,'<h2>华药网中国医药城B2C交易平台跨境商城</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">案例简介</h4><p>· 主营日本人气药品、保健食品、医疗器械、母婴用品、化妆品等的跨境零售交易；</p><p>· 与日本生产厂商，批发商，机场免税店等建立合作关系，保证质量同时价格最低。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">商业价值</h4><p>· 提供进口高品质产品；</p><p>· 实现方便快捷和低成本的海外购物。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">核心功能</h4><p>· 丰富消费者购物渠道，提供四种购物场景（海外直邮、保税仓直发、机场中转自提、机场免税店自提）；</p><p>· 与日本知名物流公司YAMATO合作，提供多种方式的物流服务；</p><p>· 与银联合作，向消费者提供安全快捷国际支付服务。</p></div><div class="row pr-md pl-md"><ul class="list list-unstyled"><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/huayao1.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/huayao2.jpg" alt=""/></div></li></ul></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('丹露网',3,'<h2>丹露网</h2><div class="featured-box-primary mb-xlg p-style"><h4>案例简介</h4><p>·&nbsp;&nbsp;专业的白酒，葡萄酒，茶等分享型饮品行业互联网平台；</p><p>·&nbsp;&nbsp;致力于整合线下酒类、茶类的配送商，终端店线下资源，使传统的线下交易，移植到线上交易。</p></div><div class="featured-box-primary mb-xs p-style" ><h4>商业价值</h4><p>·&nbsp;&nbsp;填补了线下到线上交易过程中的空缺，还在线上回归线下的过程中为B端用户提供数据支持，极大提升B端用户的交易体验和C端用户的消费体验；</p><p>·&nbsp;&nbsp;将O2O模式升级创建为更适宜饮品产业的O2O2O模式；</p><p>·&nbsp;&nbsp;该平台打造的不只是一个满足企业运营模式升级的交易平台，更将是一个满足所有用户需求并带来新型互联网体验的生态圈；</p><p>·&nbsp;&nbsp;将在互联网+浪潮下的传统饮品产业，一改过去消费互联网以眼球经济为主的商业模式，用价值经济的视角聚焦传统饮品产业与互联网的合力发展，创作出不仅限于流量的更高价值的产业形态，从而带动传统饮品产业创新升级；</p><p>·&nbsp;&nbsp;平台于2015年5月上线，2015年交易额达40亿元人民币， 2016年度交易额预计突破100亿元人民币。</p></div><div class="row pr-md pl-md"><ul class="list list-unstyled"><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/danlu1.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/danlu2.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/danlu3.jpg" alt=""/></div></li></ul></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('巨商汇B2B交易平台',3,'<h2>巨商汇B2B交易平台</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">案例简介</h4><p>·巨商汇平台用互联网的思维对传统的渠道分销模式进行了颠覆和重构，旨在为厂商和客户打造一个全流程B2B 在线交易和渠道熟客生意管理平台。</p><p>·平台目前的交易品类以家电、3C数码产品为主。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">商业价值</h4><p>·从企业价值经济的原点其切入，重构企业的价值创造方式，对传统制造业的固有商业模式进行重构、改造、升级和实施。</p><p>·为行业的营销体系变革带来颠覆性的革命，为厂家省去中间环节、省去中间层的管理，实现真正的以客户为核心。</p><p>·平台上线2年以来，交易额已突破200亿元人民币。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">核心功能</h4><p>·交易撮合、交易全流程、线上分销</p><p>·APP、微信</p><p>·电商CMS、电商客服系统</p><p>·用户中心</p></div><div class="row pr-md pl-md"><ul class="list list-unstyled"><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/jushanghui1.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/jushanghui2.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/jushanghui3.jpg" alt=""/></div></li></ul></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('中免商城',3,'<h2>中免商城</h2><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">案例简介</h4><p>·包括B2C商城和供应链管理系统；</p><p>·系统支持商品维护、商品采购、财务结算、订单处理、售后单处理等ERP 相关业务的处理；</p><p>·可通过中免商城WMS系统进行订单的发货，商品的出入库，售后商品出入库，移库移位等仓储相关业务的处理。</p></div><div style="margin-bottom: 40px" class="p-style"><h4 class="heading-primary">商业价值</h4><p>·摆脱了对E店宝软件依赖。可根据公司的发展计划定制不同经营模式，把跨境直邮业务，免税品预订业务，免税区仓储整合进现在的商城中，更好的适应中免集团的业务发展要求。</p><p>·商品管理：前台展示商品内容全部由后台设定，由ERP系统来设定商品上下架状态，价格，展示的图片内容的；</p><p>·订单管理：对前台商城所下订单，按照库房等条件进行自动拆单处理。同时，可对订单进行人工处理；</p><p>·采购管理：对所销售商品，通过供应商进行采购，预付，结算等处理；</p><p>·出入库管理：对商品的进出库房、上下架进行管理，同时管理库存量；</p><p>·售后管理：需求。对客户申请的售后处理进行审核，处理。</p></div><div class="row pr-md pl-md"><ul class="list list-unstyled"><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/zhongmianshangcheng1.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/zhongmianshangcheng2.jpg" alt=""/></div></li><li data-appear-animation="fadeInUp"><div class="mb-xlg"><img class="featured-boxes-full" src="/img/zhongmianshangcheng3.jpg" alt=""/></div></li></ul></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('海尔电商促销平台',3,'<h2 style="white-space: normal;"> 海尔电商促销平台</h2><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary"> 案例简介</h4><p>· 系统面向该客户在全国的经销体系，利用客户的用户资源和配送体系，打造端到端的3小时极速达电商平台；</p> <p> · 同时承接客户B端和C端订单，极大的优化了用户全流程购物体验；</p><p>· 系统定期组织限时限量抢购活动（B端每月一次，C端每周一次）。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">商业价值</h4><p> · 突破大件物流配送时间长的瓶颈，推出3小时极速达购物体验；</p><p>· 3小时极速达，超时免单的超强承诺；</p><p>· 平台投产上线第一年，交易额即接近10亿元人民币。B端活动高峰时，每分钟处理约400多订单，C端活动高峰时，每分钟处理约700多订单。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">核心功能</h4><p>· 订单中心、客户中心、促销中心；</p><p>· 电商交易平台（B端平台、C端平台）；</p><p> · 电商交易全流程。</p></div>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('海尔电商订单处理平台',3,'<div style="white-space: normal; margin-bottom: 40px;"><h2 style="white-space: normal;">海尔商城订单处理平台</h2><h4 class="heading-primary">案例简介</h4><p> · 为了保证活动期间商城系统快速满足用户体验需求，需对系统进行流程设计、优化开发，提升系统处理能力； </p> <p> · 实现电商交易目标，搭建订单高速处理平台，对供应链及订单交付进行整体提升，优化相关业务流程，提升单节点处理并发能力；</p><p>· 实现全流程系统监控、数据可视化、网络负载监控。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary"> 商业价值</h4><p>· 改善某商城交付平台现阶段存在的问题，提高订单交付能力、保证用户整体体验；</p><p>· 保障某商城在促销活动期间系统稳定运行，提升整体用户体验和整体交付闭环率；</p><p>· 实现全流程系统监控、数据可视化、网络负载监控。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">核心功能</h4><p> · 视网膜监控预警平台</p></div><p><br/></p>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('海尔电商库存共享平台',3,'<div style="white-space: normal; margin-bottom: 40px;"><h2 style="white-space: normal;">海尔电商库存共享平台</h2><h4 class="heading-primary">案例简介</h4><p>· 搭建大库存共享平台，支持某集团多业务模式，库存开单由先前的串联变并联；</p><p>· 实现对多库存的包括新模式平台库存，TC 共享库存等库存封装功能、实现库存优先级管理模块、实现订单全流程可视功能。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">商业价值</h4><p>· 使用其他系统、其他模式的库存，降低备货风险；</p><p>· 增加可选择库存数量，避免用户购买时无货情况，提高客户满意度。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">核心功能</h4><p>· 入库、库存查询、库存锁定、库存扣减、库存释放；</p><p> · 基础设置：匹配策略维护、可共享库龄设置、用户权限管理；</p><p> · 库存管理：库存操作历史查询、MS开单查询、库存查询、请求编号历史查询、可用库存统计报表。</p></div><p><br/></p>');
INSERT INTO solution(title,solution_group_id,detail)VALUES ('海尔商城采购平台',3,'<h2 style="white-space: normal;"> 海尔商城采购平台</h2><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">案例简介</h4><p> · 为客户商城提供采购管理平台信息化解决方案及相关产品，以改善某商城供应链现阶段存在的问题，提高采购效率、降低库存物资；</p><p> · 为某商城供应链提供采购管理平台解决方案及应用系统，打通采购管理平台与各相关系统间的接口，实现采购过程的可视化监控；</p><p>· 实现自主管理分渠道预测、采购、到货、库存以及销售开单。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">商业价值</h4><p> · 适应电商业务的高速增长态势，更好地发挥某电商在用户交互中的重要作用，以及提升电商平台的整体交付能力、降低运营成本。</p></div><div style="white-space: normal; margin-bottom: 40px;"><h4 class="heading-primary">核心功能</h4><p>· 分渠道的一体化采购管理；</p><p> · 分渠道的逆向采购业务流程 ；</p><p>· 3C、水家电产品的基地库存直发；</p><p>· 采购业务全流程可视化监控。</p></div><p><br/></p>');