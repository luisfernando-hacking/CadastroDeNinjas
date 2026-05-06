-- V2: Migration para adicionar a coluna de RANK na tabela de cadastro

ALTER TABLE tb_cadastro ADD COLUMN IF NOT EXISTS rank VARCHAR(50);