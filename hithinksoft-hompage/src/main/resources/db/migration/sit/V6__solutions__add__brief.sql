alter table solution add solution_brief longtext;

UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p>·平台基于hadoop进行保险大数据的采集、处理和挖掘分析，实现保险数据的全链条应用、保险客户的全方位管理、产品生命周期全过程的分析，通过数据推动企业管理，促进利益增长</p><img src="/img/taikang1.jpg" />' WHERE title = '泰康人寿大数据挖掘平台';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">项目简介</h4><p>·EMS数仓迁移项目是EMS将基于Teradata一体机构筑的BI数仓系统平滑迁移至大数据平台，以此帮助其解决存储空间不足、处理性能不足的问题。</p>' WHERE title = 'EMS数仓迁移项目';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">数据流转与清洗</h4><p>通过ETL（kettle、sqoop2）将RDBMS中的数据抽取到hadoop平台，经过数据稽核建立外表清除脏数据，再结合Hive中自定义UDF、UDAF、UDTF函数实现用户定制数据的转换和查询。</p><img src="/img/Hengfengbank.jpg" />' WHERE title = '恒丰银行大数据集群实施与运维';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">POC工作内容</h4><p>1、将网银数据、系统日志、账单文件通过Flume、FTP方式加载到Inceptor中，现有关系型数据库则通过定期的ETL工具sqoop和pentaho加载到Inceptor中，并对导入数据进行数据清洗与稽核。</p><img src="/img/PingAnBank.jpg" />' WHERE title = '平安银行大数据集群实施与运维';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">概述</h4><p>华信云服务平台依托于自有的云数据中心，能够针对客户的各种业务提供在线云服务和云咨询服务。在线云服务主要包括云服务器租赁服务、开发管理服务、数据存储服务、企业文件柜应用服务、贸易365业务服务等。云咨询服务主要包括私有云建设提案、应用部署提案、应用云化建设提案、云服务集成提案、云服务IT 运维提案等。</p><img src="/img/HuaXinyunservices.jpg" />' WHERE title = '华信云服务';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">概述</h4><p>华信健康云方案是将近年来IT行业主流的云计算、云存储、大数据、移动互联等技术与可穿戴设备、健康管理等先进理念结合起来，依托大连华信云数据中心强大的计算及存储、分析能力，为用户提供运动、健康、睡眠、饮食等建议和报告，满足人们主动进行健康和运动管理的需求，并通过社交网络中的各种激励形式增加参与人群的粘度，引导和帮助用户树立健康、积极的运动及生活理念。</p><img src="/img/jiankangyun1.jpg" />' WHERE title = '华信健康云';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p>· 主营日本人气药品、保健食品、医疗器械、母婴用品、化妆品等的跨境零售交易；</p><img src="/img/huayao1.jpg" />' WHERE title = '华药网中国医药城B2C交易平台跨境商城';
UPDATE solution SET solution_brief = '<h4>案例简介</h4><p>· 专业的白酒，葡萄酒，茶等分享型饮品行业互联网平台；</p><img src="/img/danlu1.jpg" />' WHERE title = '丹露网';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p>·巨商汇平台用互联网的思维对传统的渠道分销模式进行了颠覆和重构，旨在为厂商和客户打造一个全流程B2B 在线交易和渠道熟客生意管理平台。</p><img src="/img/jushanghui1.jpg" />' WHERE title = '巨商汇B2B交易平台';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p>·包括B2C商城和供应链管理系统；</p><img src="/img/zhongmianshangcheng1.jpg" />' WHERE title = '中免商城';
UPDATE solution SET solution_brief = '<h4 class="heading-primary"> 案例简介</h4><p>· 系统面向该客户在全国的经销体系，利用客户的用户资源和配送体系，打造端到端的3小时极速达电商平台；</p>' WHERE title = '海尔电商促销平台';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p> · 为了保证活动期间商城系统快速满足用户体验需求，需对系统进行流程设计、优化开发，提升系统处理能力； </p>' WHERE title = '海尔电商订单处理平台';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p>· 搭建大库存共享平台，支持某集团多业务模式，库存开单由先前的串联变并联；</p>' WHERE title = '海尔电商库存共享平台';
UPDATE solution SET solution_brief = '<h4 class="heading-primary">案例简介</h4><p> · 为客户商城提供采购管理平台信息化解决方案及相关产品，以改善某商城供应链现阶段存在的问题，提高采购效率、降低库存物资；</p>' WHERE title = '海尔商城采购平台';

alter table solution modify solution_brief longtext not null;