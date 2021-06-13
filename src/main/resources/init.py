print('SimpleBlock')
from fr.anatom3000.gwwhit.block import SimpleBlock
print('FabricBlockSettings')
from net.fabricmc.fabric.api.object.builder.v1.block import FabricBlockSettings
print('PyUtils')
from fr.anatom3000.gwwhit.util import PyUtils
print('BlockRegistry')
from fr.anatom3000.gwwhit.registry import BlockRegistry
print('GuessWhatWillHappenInThisMod')
from fr.anatom3000.gwwhit import GuessWhatWillHappenInThisMod

LOGGER = GuessWhatWillHappenInThisMod.LOGGER


LOGGER.info('[GWWHIT] Loading python stuff')


pyBlock = SimpleBlock(
	FabricBlockSettings
		.of( PyUtils.getMaterial('stone') )
		.collidable(False)
		.drops( PyUtils.makeIdentifier('minecraft', 'stone') )
		.luminance(10)
)

BlockRegistry.put('pyblock', pyBlock)


LOGGER.info('[GWWHIT] Python stuff loaded!')
