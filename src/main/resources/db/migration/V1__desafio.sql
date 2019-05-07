CREATE SEQUENCE tb_pessoa_id_pessoa_seq;
ALTER SEQUENCE tb_pessoa_id_pessoa_seq  OWNER TO postgres;
	
CREATE SEQUENCE tb_telefone_id_telefone_seq;
ALTER SEQUENCE tb_telefone_id_telefone_seq  OWNER TO postgres;

CREATE TABLE tb_pessoa (
    id_pessoa bigint NOT NULL DEFAULT nextval('tb_pessoa_id_pessoa_seq'::regclass),
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    idade integer NOT NULL,
    codigo_tipo_endereco integer NOT NULL,
    nome_endereco character varying(50) COLLATE pg_catalog."default" NOT NULL,
    cep character varying(10) COLLATE pg_catalog."default" NOT NULL,
    numero character varying(20) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tb_pessoa_pkey PRIMARY KEY (id_pessoa)
);
  
ALTER TABLE tb_pessoa OWNER TO postgres;

CREATE TABLE tb_telefone (
    id_telefone bigint NOT NULL DEFAULT nextval('tb_telefone_id_telefone_seq'::regclass),
    codigo_tipo_telefone integer NOT NULL,
    ddi character varying(10) COLLATE pg_catalog."default" NOT NULL,
    ddd character varying(10) COLLATE pg_catalog."default" NOT NULL,
    numero_telefone character varying(10) COLLATE pg_catalog."default" NOT NULL,
    pessoa_id bigint NOT NULL,
    CONSTRAINT tb_telefone_pkey PRIMARY KEY (id_telefone),
    CONSTRAINT pessoa_fkey FOREIGN KEY (pessoa_id)
    REFERENCES tb_pessoa
);
	
ALTER TABLE tb_telefone OWNER TO postgres;