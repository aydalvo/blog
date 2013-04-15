use blog;

insert into assunto (descricao, request_mapping) values ("Agile", "/Blog/comente-sobre/categoria");
insert into assunto (descricao, request_mapping) values ("Java", "/Blog/comente-sobre/java");
insert into assunto (descricao, request_mapping) values ("Engenharia de Software", "/Blog/comente-sobre/engenharia-software");
insert into assunto (descricao, request_mapping) values ("RUP", "/Blog/comente-sobre/rup");
insert into assunto (descricao, request_mapping) values ("TDD", "/Blog/comente-sobre/tdd");

commit;