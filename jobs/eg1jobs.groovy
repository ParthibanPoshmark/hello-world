String repo="parthibanposhmark/hello-world"

job("project-a/example1"){
	scm{
		github repo
	}
	triggers{
		scm 'H/10 * * * *'
	}
}