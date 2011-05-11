/*$DELIMITER:/ */
CREATE TABLE JCR_MCONTAINER(
  VERSION VARCHAR2(96) NOT NULL,
  CONSTRAINT JCR_PK_MCONTAINER PRIMARY KEY(VERSION)
)
/
CREATE TABLE JCR_MITEM(
	ID VARCHAR2(96) NOT NULL,
	PARENT_ID VARCHAR2(96) NOT NULL,
	NAME VARCHAR2(512) NOT NULL,
	VERSION INTEGER NOT NULL,
	I_CLASS INTEGER NOT NULL,
	I_INDEX INTEGER NOT NULL,
	N_ORDER_NUM INTEGER,
	P_TYPE INTEGER, 
	P_MULTIVALUED INTEGER,	
	CONSTRAINT JCR_PK_MITEM PRIMARY KEY(ID),
	CONSTRAINT JCR_FK_MITEM_PARENT FOREIGN KEY(PARENT_ID) REFERENCES JCR_MITEM(ID)
	)
/
CREATE INDEX JCR_IDX_MITEM_PARENT_FK ON JCR_MITEM(PARENT_ID)
/
CREATE UNIQUE INDEX JCR_IDX_MITEM_PARENT ON JCR_MITEM( PARENT_ID, NAME, I_INDEX, I_CLASS, VERSION DESC)
/
CREATE UNIQUE INDEX JCR_IDX_MITEM_PARENT_NAME ON JCR_MITEM(I_CLASS, PARENT_ID, NAME, I_INDEX, VERSION DESC)
/
CREATE UNIQUE INDEX JCR_IDX_MITEM_PARENT_ID ON JCR_MITEM(I_CLASS, PARENT_ID, ID, VERSION DESC)
/
CREATE TABLE JCR_MVALUE(
	ID INTEGER NOT NULL, 
	DATA BLOB, 
	ORDER_NUM INTEGER NOT NULL, 
	PROPERTY_ID VARCHAR(96) NOT NULL,
	STORAGE_DESC VARCHAR(512),
	CONSTRAINT JCR_PK_MVALUE PRIMARY KEY(ID),
	CONSTRAINT JCR_FK_MVALUE_PROPERTY FOREIGN KEY(PROPERTY_ID) REFERENCES JCR_MITEM(ID)
	)
/
CREATE UNIQUE INDEX JCR_IDX_MVALUE_PROPERTY ON JCR_MVALUE(PROPERTY_ID, ORDER_NUM)
/
CREATE sequence JCR_MVALUE_SEQ
/
CREATE OR REPLACE trigger BI_JCR_MVALUE
  before insert on JCR_MVALUE
  for each row
begin
  SELECT JCR_MVALUE_SEQ.nextval INTO :NEW.ID FROM dual;
end;
/
CREATE TABLE JCR_MREF(
  NODE_ID VARCHAR(96) NOT NULL,
  PROPERTY_ID VARCHAR(96) NOT NULL,
  ORDER_NUM INTEGER NOT NULL,
  CONSTRAINT JCR_PK_MREF PRIMARY KEY(NODE_ID, PROPERTY_ID, ORDER_NUM)
)
/
CREATE UNIQUE INDEX JCR_IDX_MREF_PROPERTY ON JCR_MREF(PROPERTY_ID, ORDER_NUM)
/