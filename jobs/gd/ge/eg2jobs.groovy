String repo="parthibanposhmark/hello-world"

job("project-a/example2"){
	scm{
		github repo
	}
	triggers{
		scm 'H/5 * * * *'
	}
}