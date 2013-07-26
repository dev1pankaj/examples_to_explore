After deploying this application to Tomcat.

URL: /batch-1/batch would start batch job that will read xml data from users.xml and will write it to database table user_.

Make sure that you have table user_ with proper columns[refer: applicationContext.xml -> jdbcWriter] in database schema batch.
