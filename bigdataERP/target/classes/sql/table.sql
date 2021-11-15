DROP TABLE TB_PRODUCT CASCADE CONSTRAINTS;

CREATE TABLE TB_PRODUCT (
       PRD_NO               VARCHAR2(12) NOT NULL,
       PRD_NM               VARCHAR2(50) NULL,
       CATEGORY_NO          VARCHAR2(12) NOT NULL,
       PRD_DES              VARCHAR2(500) NULL,
       SELL_PRC_UNIT        NUMBER(8) NULL,
       SELL_START_DT        VARCHAR2(8) NULL,
       SELL_END_DT          VARCHAR2(8) NULL,
       DLV_CONSTRAINT       VARCHAR2(500) NULL,
       AS_FLG               VARCHAR2(1) NULL,
       RETURN_FLG           VARCHAR2(1) NULL,
       IMG_ORG_FILE_NM      VARCHAR2(100) NULL,
       IMG_GEN_FILE_NM      VARCHAR2(100) NULL,
       REG_ID               VARCHAR2(20) NULL,
       REG_DTM              VARCHAR2(14) NULL,
       PRIMARY KEY (PRD_NO)
);

 create table pro_comment(
        prd_no varchar2(20) ,
        mem_id varchar2(20) , 
        pro_comment varchar2(60),
        writedate date);
        
DROP TABLE TB_CATEGORY CASCADE CONSTRAINTS;

CREATE TABLE TB_CATEGORY (
       CATEGORY_NO          VARCHAR2(12) NOT NULL,
       CATEGORY_NM          VARCHAR2(50) NULL,
       CATEGORY_DESC        VARCHAR2(500) NULL,
       REG_ID               VARCHAR2(20) NULL,
       REG_DTM              VARCHAR2(14) NULL,
       PRIMARY KEY (CATEGORY_NO)
);


DROP TABLE TB_ORDER_PRODUCT CASCADE CONSTRAINTS;

CREATE TABLE TB_ORDER_PRODUCT (
       ORD_NO               VARCHAR2(30) NOT NULL,
       PRD_NO               VARCHAR2(12) NOT NULL,
       QTY                  NUMBER(8) NULL,
       PRIMARY KEY (ORD_NO, PRD_NO)
);

DROP TABLE TB_ORDER CASCADE CONSTRAINTS;

CREATE TABLE TB_ORDER (
       ORD_NO               VARCHAR2(30) NOT NULL,
       MEM_ID               VARCHAR2(20) NOT NULL,
       ORD_AMT              NUMBER(8) NULL,
       RCVR_NM              VARCHAR2(50) NULL,
       RCVR_TEL_NO          VARCHAR2(14) NULL,
       RCVR_ADDR            VARCHAR2(100) NULL,
       DLV_CORP_NO          VARCHAR2(12) NOT NULL,
       DLV_REQ              VARCHAR2(100) NULL,
       ORD_STAT_CD          VARCHAR2(3) NULL,
       ORD_DTM              VARCHAR2(14) NULL,
       PRIMARY KEY (ORD_NO)
);
