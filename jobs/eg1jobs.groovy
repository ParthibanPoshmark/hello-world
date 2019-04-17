String repo="parthibanposhmark/hello-world"
job("example1"){
	scm{
		github repo
	}
	triggers{
		scm 'H/5 * * * *'
	}
} 