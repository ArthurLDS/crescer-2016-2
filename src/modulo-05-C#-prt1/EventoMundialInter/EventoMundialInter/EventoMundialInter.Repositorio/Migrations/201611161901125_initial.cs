namespace EventoMundialInter.Repositorio.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.DataEvento",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Data = c.DateTime(nullable: false),
                        Quantidade = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Usuario",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Email = c.String(),
                        Telefone = c.String(),
                        Cidade = c.String(),
                        Cpf = c.String(),
                        DataEvento_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.DataEvento", t => t.DataEvento_Id)
                .Index(t => t.DataEvento_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Usuario", "DataEvento_Id", "dbo.DataEvento");
            DropIndex("dbo.Usuario", new[] { "DataEvento_Id" });
            DropTable("dbo.Usuario");
            DropTable("dbo.DataEvento");
        }
    }
}
